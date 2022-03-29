package com.spring.petshop.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.petshop.user.vo.UserVO;

public interface UserController {
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addUser(@ModelAttribute("user") UserVO user,  RedirectAttributes rAttr,HttpServletRequest request,	HttpServletResponse response) throws Exception;
	public ModelAndView removeUser(@RequestParam("u_id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("user") UserVO user, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request,	HttpServletResponse response) throws Exception;
	public ModelAndView modUser(@ModelAttribute("user") UserVO user,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myPageForm(UserVO user, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
