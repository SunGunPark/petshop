package com.spring.petshop.item.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.petshop.item.vo.ItemVO;

public interface ItemService {
	public List selectItemListByClass(String i_class) throws DataAccessException;
	public ItemVO itemDetail(String itemNo);
}
