package com.spring.petshop.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.user.vo.UserVO;

public interface UserDAO {
	public List selectAllUserList() throws DataAccessException;

	public int insertUser(UserVO userVO) throws DataAccessException;

	public int deleteUser(String id) throws DataAccessException;

	public UserVO loginById(UserVO user);

	public void modUser(UserVO dto);

	public UserVO selectId(String id);

	public List selectListId(String id) throws DataAccessException;
	
	public int idChk(UserVO userVO) throws DataAccessException;
	
}
