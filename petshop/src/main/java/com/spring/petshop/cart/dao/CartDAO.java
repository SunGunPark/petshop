package com.spring.petshop.cart.dao;

import java.util.List;

import com.spring.petshop.cart.vo.CartVO;

public interface CartDAO {
	
	public List<CartVO> cartList(String user_id) throws Exception;
	public int sumMoney(String user_id) throws Exception;
	public void insertCart(CartVO cartVO) throws Exception;
	public int countCart(String itemno, String user_id) throws Exception;
	public void updateCart(CartVO cartVO) throws Exception;
	public void delete(int cartNo) throws Exception;
	public void modifyCart(CartVO cartVO) throws Exception;
}