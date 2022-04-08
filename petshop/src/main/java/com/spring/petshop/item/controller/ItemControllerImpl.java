package com.spring.petshop.item.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.petshop.common.alert.ScriptAlertUtils;
import com.spring.petshop.common.interceptor.ViewNameInterceptor;
import com.spring.petshop.common.view.ViewTools;
import com.spring.petshop.item.service.ItemService;
import com.spring.petshop.item.vo.ItemVO;
import com.spring.petshop.user.service.UserService;
import com.spring.petshop.user.vo.UserVO;

@EnableAspectJAutoProxy
@Controller
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemService itemService;
	//@Autowired
	//private ItemVO itemVO;
	@Autowired
	private UserService userService;
	
	ViewTools viewTools = new ViewTools();
	
	@Override
	@RequestMapping(value = "/item/itemListForm.do", method = RequestMethod.GET)
	public ModelAndView itemListForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String i_class = request.getParameter("i_class");
		String viewName = viewTools.getViewName(request);
		List itemList = itemService.selectItemListByClass(i_class);
		mav.addObject("itemList",itemList);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/item/itemDetail.do",method = RequestMethod.GET)
	public ModelAndView itemDetail(@RequestParam("itemno") String articleNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = viewTools.getViewName(request);
		ItemVO itemVO = itemService.itemDetail(articleNo);
		mav.addObject("itemVO", itemVO);
		mav.setViewName(viewName);
		return mav;
	}
}
