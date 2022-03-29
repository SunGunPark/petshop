package com.spring.petshop.board.service;


import java.util.List;

import com.spring.petshop.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> Boardlist();

	public int addBoard(BoardVO boardVO);

	public BoardVO boardView(int boardNo);

	public void updateBoard(BoardVO boardVO);
	
	public void removeBoard(int boardNo);

}
