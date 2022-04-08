package com.spring.petshop.cart.service;

import java.util.List;

import com.spring.petshop.cart.vo.CartVO;

public interface CartService {
	
	public List<CartVO> cartList(String user_id) throws Exception;
	public int sumMoney(String user_Id) throws Exception;
	public void insertCart(CartVO cartvo) throws Exception;
	public int countCart(String itemno, String user_id) throws Exception;
	public void updateCart(CartVO cartVO) throws Exception;
	public void deleteCart(int CartNo) throws Exception;
	public void modifyCart(CartVO cartVO) throws Exception;
}
