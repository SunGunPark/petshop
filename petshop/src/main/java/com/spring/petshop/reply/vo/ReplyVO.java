package com.spring.petshop.reply.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("replyVO")
public class ReplyVO {
	
	private int BoardNo;
	private int ReplyNo;
	private String r_content;
	private String r_writer;
	private Date r_date;
	
	public ReplyVO() {}

	public int getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}

	public int getReplyNo() {
		return ReplyNo;
	}

	public void setReplyNo(int replyNo) {
		ReplyNo = replyNo;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_writer() {
		return r_writer;
	}

	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	
}
