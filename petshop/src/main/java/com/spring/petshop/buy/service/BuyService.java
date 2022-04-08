package com.spring.petshop.buy.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.buy.vo.BuyVO;

public interface BuyService {

	public void insertBuy(String userId) throws Exception;

	public List<BuyVO> buyList(String user_id) throws Exception;

	public void removeBuy(int buyNo) throws DataAccessException;

	public void cartAllDelete(String userId) throws Exception;

}
