package com.spring.petshop.item.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ItemDAO {
	public List selectItemListByClass(String i_class) throws DataAccessException;
}
