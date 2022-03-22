package com.spring.petshop.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.petshop.member.vo.MemberVO;

@Repository("MemberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO loginById(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", member);
		return vo;
	}
	
	@Override
	public void modMember(MemberVO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.member.modMember", dto);
	}

	@Override
	public MemberVO selectId(String id) {
		// TODO Auto-generated method stub
		return (MemberVO) sqlSession.selectOne("mapper.member.selectId", id);
	}
}
