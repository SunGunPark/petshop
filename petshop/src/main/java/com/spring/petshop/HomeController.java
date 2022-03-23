package com.spring.petshop;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/user/myPage.do", method = RequestMethod.GET)
	public String myPage(Locale locale, Model model) {
		return "/user/myPage";
	}
	
	@RequestMapping(value = "/board/board.do", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		return "/board/baord";
	}
	
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "/user/login";
	}
	
	@RequestMapping(value = "/user/register.do", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "/user/register";
	}
	
}
