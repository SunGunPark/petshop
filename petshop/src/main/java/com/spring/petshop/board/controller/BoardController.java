package com.spring.petshop.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.petshop.board.vo.BoardVO;
import com.spring.petshop.reply.vo.ReplyVO;


public interface BoardController {
	
	public ModelAndView Boardlist(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView registerBoard(@ModelAttribute("borad") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView form(HttpServletRequest request, HttpServletResponse resposne) throws Exception;
	
	public ModelAndView viewArticle(@RequestParam("articleNo") int articleNo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateBoard(@ModelAttribute BoardVO boardVO, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity removeBoard(@RequestParam("boardNo") int boardNo, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView writeReply(@ModelAttribute("replyVO") ReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteReply(@ModelAttribute("replyVO") ReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
