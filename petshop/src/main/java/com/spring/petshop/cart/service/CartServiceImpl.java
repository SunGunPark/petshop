package com.spring.petshop.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.cart.dao.CartDAO;
import com.spring.petshop.cart.vo.CartVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Override
	public List<CartVO> cartList(String user_id) throws Exception {
		
		return cartDAO.cartList(user_id);
	}

	@Override
	public int sumMoney(String user_Id) throws Exception {
		
		return cartDAO.sumMoney(user_Id);
	}

	@Override
	public void insertCart(CartVO cartvo) throws Exception {
		
		cartDAO.insertCart(cartvo);
	}

	@Override
	public int countCart(String itemno, String user_id) throws Exception {
		
		return cartDAO.countCart(itemno, user_id);
	}

	@Override
	public void updateCart(CartVO cartVO) throws Exception {
		
		cartDAO.updateCart(cartVO);
	}
	
	@Override
	public void deleteCart(int CartNo) throws Exception {
		
		cartDAO.delete(CartNo);
	}

	@Override
	public void modifyCart(CartVO cartVO) throws Exception {
		
		cartDAO.modifyCart(cartVO);
	}

}
