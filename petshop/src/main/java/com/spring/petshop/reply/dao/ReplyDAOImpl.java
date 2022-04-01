package com.spring.petshop.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.petshop.reply.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 댓글보기
	@Override
	public List<ReplyVO> selectReplyList(int boardNo) throws Exception {
		
		return sqlSession.selectList("mapper.reply.selectReplyList" ,boardNo);
	}

	@Override
	public int writeReply(ReplyVO replyVO) throws Exception {
		
		int result = sqlSession.insert("mapper.reply.writeReply", replyVO);
		return result;
	}

	@Override
	public void deleteReply(ReplyVO replyVO) throws Exception {
		
		sqlSession.delete("mapper.reply.deleteReply", replyVO);
	}

	

	
	
}
