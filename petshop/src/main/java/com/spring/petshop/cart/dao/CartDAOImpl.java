package com.spring.petshop.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.petshop.cart.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CartVO> cartList(String user_id) throws Exception {
		
		return sqlSession.selectList("mapper.cart.cartList" ,user_id);
	}

	@Override
	public int sumMoney(String user_id) throws Exception {
		
		return sqlSession.selectOne("mapper.cart.sumMoney", user_id);
	}

	@Override
	public void insertCart(CartVO cartVO) throws Exception {
		
		sqlSession.insert("mapper.cart.insertCart", cartVO);
		
	}

	@Override
	public int countCart(String itemno, String user_id) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemno", itemno);
		map.put("user_id", user_id);
		return sqlSession.selectOne("mapper.cart.countCart", map);
	}

	@Override
	public void updateCart(CartVO cartVO) throws Exception {
		
		sqlSession.update("mapper.cart.updateCart", cartVO);
	}
	
	@Override
	public void delete(int cartNo) throws Exception {
		
		sqlSession.delete("mapper.cart.deleteCart", cartNo);
	}

	@Override
	public void modifyCart(CartVO cartVO) throws Exception {
		
		sqlSession.update("mapper.cart.modifyCart", cartVO);
	}

}
