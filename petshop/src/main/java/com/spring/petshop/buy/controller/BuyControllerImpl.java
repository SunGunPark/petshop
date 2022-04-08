package com.spring.petshop.buy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.petshop.buy.service.BuyService;
import com.spring.petshop.buy.vo.BuyVO;
import com.spring.petshop.cart.vo.CartVO;
import com.spring.petshop.common.alert.ScriptAlertUtils;
import com.spring.petshop.user.service.UserService;
import com.spring.petshop.user.vo.UserVO;

@Controller
public class BuyControllerImpl implements BuyController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private BuyService buyService;
	@Autowired
	private UserVO userVO;
	@Autowired
	BuyVO buyVO;
	
	@Override
	@RequestMapping(value="/buy/insertBuy.do", method=RequestMethod.GET)
	public ModelAndView insertBuy(@ModelAttribute("cartVO") CartVO cartVO, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		String userId = userVO.getUser_id();
		buyVO.setUser_id(userId);
		buyService.insertBuy(userId);
		buyService.cartAllDelete(userId);
		scriptAlertUtils.alertAndMovePage(response, "구매가 완료되었습니다.","/petshop/user/myPageForm.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/buy/removeBuy.do", method=RequestMethod.GET)
	public ModelAndView removeBuy(@RequestParam int buyNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		buyService.removeBuy(buyNo);
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		scriptAlertUtils.alertAndMovePage(response, "삭제가 완료되었습니다.", "/petshop/user/myPageForm.do");
		ModelAndView mav = new ModelAndView("redirect:/");
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
}
