package com.spring.petshop.board.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.petshop.board.service.BoardService;
import com.spring.petshop.board.vo.BoardVO;


@Controller
public class BoardControllerImpl implements BoardController{
	
	@Autowired
	BoardService boardService;
	@Autowired
	BoardVO boardVO;
	
	@Override
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.GET)
	public ModelAndView Boardlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = (String)request.getAttribute("viewName");
		String viewName = getViewName(request);
		System.out.println(viewName);
		List<BoardVO> boardList = boardService.Boardlist();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardList", boardList);
		return mav;
	}
	
	
	@RequestMapping(value="/board/boardView.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("boardNo") int articleNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		BoardVO boardVO = boardService.boardView(articleNo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardVO", boardVO);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/board/registerBoard.do", method=RequestMethod.POST)
	public ModelAndView registerBoard(@ModelAttribute("boradVO") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		result = boardService.addBoard(boardVO);
		ModelAndView mav = new ModelAndView("redirect:/board/boardList.do");
		
		return mav;
	}
	
	
	@RequestMapping(value="/board/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse resposne) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	
	@Override
	@RequestMapping(value="/board/modArticle.do", method=RequestMethod.POST)
	public ModelAndView updateBoard(@ModelAttribute BoardVO boardVO, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		boardService.updateBoard(boardVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/boardList.do");
		mav.addObject("boardVO", boardService.boardView(boardVO.getBoardNo()));
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/board/removeBoard.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeBoard(int boardNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "text/html;charset=utf-8");
		
		try {
			boardService.removeBoard(boardNo);
			
			message = "<script>";
			message += "alert('글이 삭제 되었습니다.');";
			message += "location.href='/petshop/board/boardList.do';";
			message +="</script>";
			
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 삭제 하세요.');";
			message += "location.href='/petshop/board/boardList.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
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
