package com.spring.petshop.item.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ItemService {
	public List selectItemListByClass(String i_class) throws DataAccessException;
}
