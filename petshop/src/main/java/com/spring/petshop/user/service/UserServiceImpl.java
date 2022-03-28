package com.spring.petshop.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.user.dao.UserDAO;
import com.spring.petshop.user.vo.UserVO;

@Service("UserService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List listUsers() throws DataAccessException {
		List usersList = null;
		usersList = userDAO.selectAllUserList();
		return usersList;
	}

	@Override
	public int addUser(UserVO user) throws DataAccessException {
		return userDAO.insertUser(user);
	}

	@Override
	public int removeUser(String id) throws DataAccessException {
		return userDAO.deleteUser(id);
	}

	@Override
	public UserVO login(UserVO user) {
		return userDAO.loginById(user);
	}

	@Override
	public void modUser(UserVO dto) {
		userDAO.modUser(dto);
	}

	@Override
	public UserVO selectId(String id) {
		return userDAO.selectId(id);
	}

	@Override
	public List selectListId(String id) throws DataAccessException {
		List usersList = null;
		usersList = userDAO.selectListId(id);
		return usersList;
	}

	@Override
	public int idChk(UserVO userVO) throws DataAccessException {
		int result = userDAO.idChk(userVO);
		return result;
	}

}
