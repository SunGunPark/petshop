package com.spring.petshop.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.member.vo.MemberVO;


public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	public MemberVO loginById(MemberVO member);
	public void modMember(MemberVO dto);
	public MemberVO selectId(String id);
}
