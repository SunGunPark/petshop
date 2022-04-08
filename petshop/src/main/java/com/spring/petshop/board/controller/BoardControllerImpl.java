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
import com.spring.petshop.reply.service.ReplyService;
import com.spring.petshop.reply.vo.ReplyVO;


@Controller
public class BoardControllerImpl implements BoardController{
	
	@Autowired
	BoardService boardService;
	@Autowired
	ReplyService replyService;
	@Autowired
	BoardVO boardVO;
	@Autowired
	ReplyVO replyVO;
	
	
	@Override
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.GET)
	public ModelAndView Boardlist(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String)request.getAttribute("viewName");
		List<BoardVO> boardList = boardService.Boardlist();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardList", boardList);
		return mav;
	}
	
	
	@RequestMapping(value="/board/boardView.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("boardNo") int boardNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		BoardVO boardVO = boardService.boardView(boardNo);
		
		// 댓글리스트
		List<ReplyVO> replyList = replyService.selectReplyList(boardNo);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardVO", boardVO);
		mav.addObject("replyList", replyList);
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
			message += "alert('댓글이 있는 게시물은 삭제할 수 없습니다');";
			message += "location.href='/petshop/board/boardList.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}
	
	
	//댓글 쓰기
	@Override
	@RequestMapping(value="/board/writeReply.do", method=RequestMethod.POST)
	public ModelAndView writeReply(@ModelAttribute("replyVO") ReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String boardNo = request.getParameter("baordNo");
		replyService.writeReply(replyVO);
		ModelAndView mav = new ModelAndView("redirect:/board/boardView.do?boardNo="+boardNo);
		return mav;
	}


	//댓글 제거
	@Override
	@RequestMapping(value="/board/deleteReply.do", method=RequestMethod.GET)
	public ModelAndView deleteReply(@ModelAttribute("replyVO") ReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		replyService.deleteReply(replyVO);
		String boardNo = request.getParameter("baordNo");
		ModelAndView mav = new ModelAndView("redirect:/board/boardView.do?boardNo="+boardNo);
		return mav;
	}
	
	
	
	
	
}
