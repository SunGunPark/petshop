package com.spring.petshop.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.petshop.user.vo.UserVO;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllUserList() throws DataAccessException {
		List<UserVO> usersList = null;
		usersList = sqlSession.selectList("mapper.user.selectAllUserList");
		return usersList;
	}

	@Override
	public int insertUser(UserVO userVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.user.insertUser", userVO);
		return result;
	}

	@Override
	public int deleteUser(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.user.deleteUser", id);
		return result;
	}

	@Override
	public UserVO loginById(UserVO user) {
		UserVO vo = sqlSession.selectOne("mapper.user.loginById", user);
		return vo;
	}

	@Override
	public void modUser(UserVO dto) {
		sqlSession.update("mapper.user.modUser", dto);
	}

	@Override
	public UserVO selectId(String id) {
		return (UserVO) sqlSession.selectOne("mapper.user.selectId", id);
	}

	@Override
	public List selectListId(String id) throws DataAccessException {
		List<UserVO> usersList = null;
		usersList = sqlSession.selectList("mapper.user.selectListId", id);
		return usersList;
	}

	@Override
	public int idChk(UserVO userVO) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.user.idChk", userVO);
		return result;
	}
	
	

}
