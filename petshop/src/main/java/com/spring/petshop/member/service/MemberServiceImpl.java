package com.spring.petshop.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.member.dao.MemberDAO;
import com.spring.petshop.member.vo.MemberVO;

@Service("MemberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDAO.loginById(member);
	}
	
	
	public void modMember(MemberVO dto) {
		// TODO Auto-generated method stub
		memberDAO.modMember(dto);
	}

	
	public MemberVO selectId(String id) {
		// TODO Auto-generated method stub
		return memberDAO.selectId(id);
	}
}
