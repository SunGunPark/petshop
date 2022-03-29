package com.spring.petshop.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.petshop.common.alert.ScriptAlertUtils;
import com.spring.petshop.user.service.UserService;
import com.spring.petshop.user.vo.UserVO;

@EnableAspectJAutoProxy
@Controller("userController")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserVO userVO;

	@Override
	@RequestMapping(value = "/user/listUsers.do", method = RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List usersList = userService.listUsers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("usersList", usersList);
		return mav;
	}

	// 유저 로그인
	@Override
	@RequestMapping(value = "/user/register.do")
	public ModelAndView addUser(UserVO user, RedirectAttributes rAttr,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		int result = userService.idChk(user);
		ModelAndView mav = new ModelAndView();
		if(result == 0) {
			result = userService.addUser(user);
			scriptAlertUtils.alertAndMovePage(response, "회원가입에 성공하였습니다.", "/petshop");
		}else if(result == 1) {
			rAttr.addAttribute("result", "registerFailed");
			scriptAlertUtils.alertAndBackPage(response, "중복된 아이디입니다.");
		}
		return mav;
	}
	
	@RequestMapping(value="/idChk.do" , method = RequestMethod.POST)
	public int idChk(UserVO user) throws Exception {
		int result = userService.idChk(user);
		return result;
	}
	
	@Override
	@RequestMapping(value = "/user/removeUser.do")
	public ModelAndView removeUser(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		userService.removeUser(id);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		if(!userVO.getUser_id().equals("admin")) {
			session.invalidate();
		}
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		scriptAlertUtils.alertAndMovePage(response, "삭제가 완료되었습니다.", "/petshop");
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}

	@RequestMapping(value = "/user/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "result", required = false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/user/login.do")
	public ModelAndView login(UserVO user, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		mav.setViewName("/user/login");
		userVO = userService.login(user);
		if (userVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userVO);
			session.setAttribute("isLogOn", true);
			System.out.println("로그인 성공");
			scriptAlertUtils.alertAndMovePage(response, userVO.getU_name()+"님 환영합니다.", "/petshop");
		} else{
			rAttr.addAttribute("result", "loginFailed");
			scriptAlertUtils.alertAndBackPage(response, "로그인에 실패하였습니다.");
			System.out.println("로그인 실패");
			//mav.setViewName("redirect:/user/login.do");
		}
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

	@Override
	@RequestMapping(value = "/user/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		HttpSession session = request.getSession();
		session.invalidate();
		
		scriptAlertUtils.alertAndMovePage(response, "정상적으로 로그아웃되었습니다.", "/petshop");
		return mav;
	}

	@Override
	@RequestMapping(value = "/user/modUser.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView modUser(@ModelAttribute("user") UserVO user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String action = request.getParameter("action");

		ModelAndView mav = new ModelAndView();
		if (action == null) {
			String user_id = request.getParameter("user_id");
			UserVO userVO = userService.selectId(user_id);
			System.out.println("DB 전 : " + userVO.getU_name());
			mav.addObject("userVO", userVO);
			mav.setViewName(getViewName(request));
		} else if (action.equals("mod")) {
			System.out.println("DB 후 : " + user.getU_name());
			userService.modUser(user);
			scriptAlertUtils.alertAndMovePage(response, "정보 수정이 완료되었습니다.", "/petshop");
		}
		return mav;
	}

	// 마이페이지
	@Override
	@RequestMapping(value = "/user/myPageForm.do")
	public ModelAndView myPageForm(UserVO user, RedirectAttributes rAttr,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		List usersList = null;
		if(userVO != null) {
			System.out.println("접속 완료");
			if(userVO.getUser_id().equals("admin")) {
				System.out.println("admin 페이지");
				usersList = userService.listUsers();
			} else {
				System.out.println(userVO.getUser_id() + "님 정보 출력");
				usersList = userService.selectListId(userVO.getUser_id());
			}
		} else {
			System.out.println("접속 실패");
			scriptAlertUtils.alertAndBackPage(response, "로그인이 필요한 기능입니다.");
		}
		mav.addObject("usersList", usersList);
		System.out.println("myPageForm 실행 확인");
		return mav;
	}
	
}


