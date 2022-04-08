package com.spring.petshop.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.petshop.item.dao.ItemDAO;
import com.spring.petshop.item.vo.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDAO;
	@Override
	public List selectItemListByClass(String i_class) throws DataAccessException {
		List itemList = null;
		itemList = itemDAO.selectItemListByClass(i_class);
		return itemList;
	}
	@Override
	public ItemVO itemDetail(String itemNo) {
		return itemDAO.selectItem(itemNo);
	}

}
