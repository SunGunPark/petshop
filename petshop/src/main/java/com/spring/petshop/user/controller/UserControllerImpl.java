package com.spring.petshop.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.spring.petshop.buy.service.BuyService;
import com.spring.petshop.buy.vo.BuyVO;
import com.spring.petshop.common.alert.ScriptAlertUtils;
import com.spring.petshop.common.view.ViewTools;
import com.spring.petshop.user.service.UserService;
import com.spring.petshop.user.vo.UserVO;

@EnableAspectJAutoProxy
@Controller("userController")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserVO userVO;
	@Autowired
	private BuyService buyService;
	
	ViewTools viewTools = new ViewTools();
	
	@Override
	@RequestMapping(value = "/user/listUsers.do", method = RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = viewTools.getViewName(request);
		List usersList = userService.listUsers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("usersList", usersList);
		return mav;
	}

	// 유저 로그인
	@Override
	@RequestMapping(value = "/user/register.do")
	public ModelAndView addUser(UserVO user, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		if (user.getU_pwd() == null || user.getU_pwd().equals("")) {
			scriptAlertUtils.alertAndBackPage(response, "잘못된 비밀번호입니다.");
		} else if (user.getU_name() == null || user.getU_name().equals("")) {
			scriptAlertUtils.alertAndBackPage(response, "잘못된 이름입니다.");
		} else if (user.getU_phone() == null || user.getU_phone().equals("")) {
			scriptAlertUtils.alertAndBackPage(response, "잘못된 전화번호입니다.");
		} else if (user.getU_address() == null || user.getU_address().equals("")) {
			scriptAlertUtils.alertAndBackPage(response, "잘못된 주소입니다.");
		} 
		int result = userService.idChk(user);
		ModelAndView mav = new ModelAndView();
		if (result == 0) {
			result = userService.addUser(user);
			scriptAlertUtils.alertAndMovePage(response, "회원가입에 성공하였습니다.", "/petshop");
		} else if (result == 1) {
			rAttr.addAttribute("result", "registerFailed");
			scriptAlertUtils.alertAndBackPage(response, "중복된 아이디입니다.");
		}
		return mav;
	}

	@RequestMapping(value = "/idChk.do", method = RequestMethod.POST)
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
		UserVO userVO = (UserVO) session.getAttribute("user");
		if (!userVO.getUser_id().equals("admin")) {
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
		String viewName = viewTools.getViewName(request);
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
			scriptAlertUtils.alertAndMovePage(response, userVO.getU_name() + "님 환영합니다.", "/petshop");
		} else {
			rAttr.addAttribute("result", "loginFailed");
			scriptAlertUtils.alertAndBackPage(response, "로그인에 실패하였습니다.");
			System.out.println("로그인 실패");
			// mav.setViewName("redirect:/user/login.do");
		}
		return mav;
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
			mav.setViewName(viewTools.getViewName(request));
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
	public ModelAndView myPageForm(UserVO user, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String viewName = viewTools.getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		List usersList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuyVO> buyList = null;
		if (userVO != null) {
			System.out.println("접속 완료");
			if (userVO.getUser_id().equals("admin")) {
				System.out.println("admin 페이지");
				usersList = userService.listUsers();
			} else {
				String userId = userVO.getUser_id();
				usersList = userService.selectListId(userVO.getUser_id());
				buyList = buyService.buyList(userId);
				map.put("buyList", buyList);
			}
		} else {
			System.out.println("접속 실패");
			scriptAlertUtils.alertAndBackPage(response, "로그인이 필요한 기능입니다.");
		}
		mav.addObject("map", map);
		mav.addObject("usersList", usersList);
		return mav;
	}

}
