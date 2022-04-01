package com.spring.petshop.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.board.dao.BoardDAO;
import com.spring.petshop.board.vo.BoardVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> Boardlist() {

		List<BoardVO> boradlist = boardDAO.selectBoardList();
		return boradlist;
	}

	@Override
	public int addBoard(BoardVO boardVO) {
		
		return boardDAO.insertBoard(boardVO);
	}

	@Override
	public BoardVO boardView(int boardNo) {
		
		return boardDAO.selectBoard(boardNo);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void removeBoard(int boardNo) {
		
		boardDAO.removeBoard(boardNo);
	}
	
}
