package com.spring.petshop.buy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.buy.vo.BuyVO;

public interface BuyDAO {

	public void insertBuy(String userId) throws Exception;

	public List<BuyVO> buyList(String user_id)throws Exception;

	public void deleteBuy(int buyNo) throws DataAccessException;

	public void cartAllDelete(String userId) throws Exception;

}
