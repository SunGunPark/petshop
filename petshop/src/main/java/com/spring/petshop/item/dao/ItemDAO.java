package com.spring.petshop.item.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.item.vo.ItemVO;

public interface ItemDAO {
	public List selectItemListByClass(String i_class) throws DataAccessException;
	
	public ItemVO selectItem(String itemNo);
}
