package com.spring.petshop.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.spring.petshop.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	public MemberVO login(MemberVO member);
	public void modMember(MemberVO dto);
	public MemberVO selectId(String id);
}
