package com.spring.petshop.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.reply.dao.ReplyDAO;
import com.spring.petshop.reply.vo.ReplyVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDAO replyDAO;
	
	@Override
	public List<ReplyVO> selectReplyList(int boardNo) throws Exception {
		
		return replyDAO.selectReplyList(boardNo);
	}

	@Override
	public int writeReply(ReplyVO replyVO) throws Exception {
		
		return replyDAO.writeReply(replyVO);
	}

	@Override
	public void deleteReply(ReplyVO replyVO) throws Exception {
		
		replyDAO.deleteReply(replyVO);
	}

}
