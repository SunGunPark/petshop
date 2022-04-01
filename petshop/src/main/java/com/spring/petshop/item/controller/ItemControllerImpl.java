package com.spring.petshop.item.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.petshop.common.view.ViewTools;
import com.spring.petshop.item.service.ItemService;
import com.spring.petshop.item.vo.ItemVO;

@EnableAspectJAutoProxy
@Controller
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemService itemService;
	//@Autowired
	//private ItemVO itemVO;
	
	@Override
	@RequestMapping(value = "/item/itemListForm.do", method = RequestMethod.GET)
	public ModelAndView itemListForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ViewTools viewTools = new ViewTools();
		ModelAndView mav = new ModelAndView();
		String i_class = request.getParameter("i_class");
		String viewName = viewTools.getViewName(request);
		List itemList = itemService.selectItemListByClass(i_class);
		mav.addObject("itemList",itemList);
		mav.setViewName(viewName);
		return mav;
	}

}
