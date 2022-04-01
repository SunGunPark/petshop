package com.spring.petshop.reply.service;

import java.util.List;

import com.spring.petshop.reply.vo.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> selectReplyList(int boardNo) throws Exception;
	
	public int writeReply(ReplyVO replyVO) throws Exception;
	
	public void deleteReply(ReplyVO replyVO) throws Exception;
	
}
