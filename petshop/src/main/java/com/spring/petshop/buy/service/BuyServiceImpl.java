package com.spring.petshop.buy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.buy.dao.BuyDAO;
import com.spring.petshop.buy.vo.BuyVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BuyServiceImpl implements BuyService{
	
	@Autowired
	private BuyDAO buyDAO;
	
	@Override
	public void insertBuy(String userId) throws Exception {
		buyDAO.insertBuy(userId);
	}

	@Override
	public List<BuyVO> buyList(String user_id) throws Exception {
		return buyDAO.buyList(user_id);
	}

	@Override
	public void removeBuy(int buyNo) throws DataAccessException {
		buyDAO.deleteBuy(buyNo);
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		buyDAO.cartAllDelete(userId);
	}

}
