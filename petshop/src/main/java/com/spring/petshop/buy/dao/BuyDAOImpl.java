package com.spring.petshop.buy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.petshop.buy.vo.BuyVO;

@Repository
public class BuyDAOImpl implements BuyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBuy(String userId) throws Exception {
		
		sqlSession.insert("mapper.buy.insertBuy", userId);
		
	}

	@Override
	public List<BuyVO> buyList(String user_id) throws Exception {
		return sqlSession.selectList("mapper.buy.buyList", user_id);
	}

	@Override
	public void deleteBuy(int buyNo) throws DataAccessException {
		sqlSession.delete("mapper.buy.deleteBuy", buyNo);
		
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		sqlSession.delete("mapper.buy.cartAllDelete",userId);
	}

	
}
