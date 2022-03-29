package com.spring.petshop.board.dao;


import java.util.List;

import com.spring.petshop.board.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> selectBoardList();
	
	public BoardVO selectBoard(int boardNo);

	public int insertBoard(BoardVO boardVO);

	public void removeBoard(int boardNo);

	public void updateBoard(BoardVO boardVO);

}
