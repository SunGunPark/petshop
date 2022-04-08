package com.spring.petshop.cart.controller;

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

import com.spring.petshop.cart.service.CartService;
import com.spring.petshop.cart.vo.CartVO;
import com.spring.petshop.common.alert.ScriptAlertUtils;
import com.spring.petshop.common.view.ViewTools;
import com.spring.petshop.user.vo.UserVO;

@Controller
public class CartControllerImpl implements CartController {

	@Autowired
	CartService cartService;
	@Autowired
	CartVO cartVO;
	
	ViewTools viewTools = new ViewTools();
	
	@Override
	@RequestMapping(value="/cart/cartList.do", method=RequestMethod.GET)
	public ModelAndView cartlist(HttpSession session, HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String viewName = viewTools.getViewName(request);
		UserVO userVO = (UserVO)session.getAttribute("user");
		ModelAndView mav = new ModelAndView(viewName);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVO> list = null;
		if(userVO != null) {
			String userId = userVO.getUser_id();
			list = cartService.cartList(userId);
			int sumMoney = cartService.sumMoney(userId);
			map.put("list", list);
			map.put("count", list.size());
			map.put("sumMoney", sumMoney);
		}else {
			scriptAlertUtils.alertAndBackPage(response, "로그인이 필요한 기능입니다.");
		}
		mav.addObject("map", map);
		return mav;
	}

	@Override
	@RequestMapping(value="/cart/insertCart.do", method=RequestMethod.POST)
	public ModelAndView insertCart(@ModelAttribute("cartVO") CartVO cartVO, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserVO userVO = (UserVO)session.getAttribute("user");
		ScriptAlertUtils scriptAlertUtils = new ScriptAlertUtils();
		String viewName = viewTools.getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		if(userVO != null) {
			String userId = userVO.getUser_id();
			cartVO.setUser_id(userId);
			int count = cartService.countCart(cartVO.getItemno(), userId);
			if(count==0) {
				cartService.insertCart(cartVO);
			} else {
				cartService.updateCart(cartVO);
			}
			scriptAlertUtils.alertAndMovePage(response, "장바구니 담기가 완료되었습니다.","/petshop/cart/cartList.do");
			
		}else {
			scriptAlertUtils.alertAndBackPage(response, "로그인이 필요한 기능입니다.");
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cart/deleteCart.do", method=RequestMethod.GET)
	public ModelAndView deleteCart(@RequestParam int cartNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		cartService.deleteCart(cartNo);
		ModelAndView mav = new ModelAndView("redirect:/cart/cartList.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/cart/modifyCart.do", method=RequestMethod.POST)
	public ModelAndView modifyCart(@RequestParam int[] c_amount, @RequestParam String[] itemno, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserVO userVO = (UserVO)session.getAttribute("user");
		String userId = userVO.getUser_id();
		
		for(int i=0;i<itemno.length;i++) {
			CartVO cartVO = new CartVO();
			cartVO.setUser_id(userId);
			cartVO.setC_amount(c_amount[i]);
			cartVO.setItemno(itemno[i]);
			cartService.modifyCart(cartVO);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/cart/cartList.do");
		return mav;
		
	}



}
