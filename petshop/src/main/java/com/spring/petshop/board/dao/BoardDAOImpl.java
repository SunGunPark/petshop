package com.spring.petshop.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.petshop.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectBoardList() {
		
		List<BoardVO> boardList = sqlSession.selectList("mapper.board.selectBoardList");
		return boardList;
	}
	
	@Override
	public BoardVO selectBoard(int boardNo) {

		return sqlSession.selectOne("mapper.board.selectBoard", boardNo);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {

		int result = sqlSession.insert("mapper.board.insertBoard", boardVO);
		return result;
	}

	
	@Override
	public void removeBoard(int boardNo) {
		
		sqlSession.delete("mapper.board.deleteBoard", boardNo);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) {
		
		sqlSession.update("mapper.board.updateBoard", boardVO);
	}
	
}
