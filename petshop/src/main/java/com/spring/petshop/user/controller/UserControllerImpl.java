package com.spring.petshop.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.petshop.user.service.UserService;
import com.spring.petshop.user.vo.UserVO;

@EnableAspectJAutoProxy
//@Controller("UserController")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserVO userVO;
	
	@Override
	@RequestMapping(value="/user/myPage.do" ,method = RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List usersList = userService.listUsers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("usersList", usersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/user/register.do" ,method = RequestMethod.POST)
	public ModelAndView addUser(UserVO user, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = userService.addUser(user);
		ModelAndView mav = new ModelAndView("redirect:/user/listUsers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/user/removeUser.do" ,method = RequestMethod.GET)
	public ModelAndView removeUser(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		userService.removeUser(id);
		ModelAndView mav = new ModelAndView("redirect:/user/listUsers.do");
		return mav;
	}
	
	
	@RequestMapping(value = "/user/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(
			@RequestParam(value="result", required = false) String result, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public ModelAndView login(UserVO user, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		userVO = userService.login(user);
		if(userVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/user/listUsers.do");
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/user/loginForm.do");
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
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}

	@Override
	@RequestMapping(value="/user/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		mav.setViewName("redirect:/user/loginForm.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/user/modUser.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modUser(
			@ModelAttribute("user") UserVO user, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		ModelAndView mav = new ModelAndView();
		if(action == null) {
			String id = request.getParameter("id");
			UserVO userVO = userService.selectId(id);
			System.out.println("DB 전 : " + userVO.getU_name());
			mav.addObject("userVO", userVO);
			mav.setViewName(getViewName(request));
		} else if(action.equals("mod")) {
			System.out.println("DB 후 : "+ user.getU_name());
			userService.modUser(user);
			
			mav.setViewName("redirect:/user/listUsers.do");
		}
		return mav;
	}

}
