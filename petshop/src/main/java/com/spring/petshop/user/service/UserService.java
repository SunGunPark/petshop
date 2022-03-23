package com.spring.petshop.user.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.user.vo.UserVO;

public interface UserService {
	public List listUsers() throws DataAccessException;
	public int addUser(UserVO user) throws DataAccessException;
	public int removeUser(String id) throws DataAccessException;
	public UserVO login(UserVO user);
	public void modUser(UserVO dto);
	public UserVO selectId(String id);
}
