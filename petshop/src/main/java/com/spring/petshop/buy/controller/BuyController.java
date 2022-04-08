package com.spring.petshop.buy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.petshop.cart.vo.CartVO;

public interface BuyController {

	ModelAndView insertBuy(CartVO cartVO, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView removeBuy(int buyNo, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
