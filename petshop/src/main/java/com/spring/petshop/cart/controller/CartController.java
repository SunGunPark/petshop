package com.spring.petshop.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.petshop.cart.vo.CartVO;



public interface CartController {
	
	public ModelAndView cartlist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView insertCart(@ModelAttribute("cartVO") CartVO cartVO, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleteCart(@RequestParam int cartNo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyCart(@RequestParam int[] c_amount, @RequestParam String[] itemno, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
