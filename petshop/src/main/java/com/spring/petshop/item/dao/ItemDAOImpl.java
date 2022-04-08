package com.spring.petshop.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.petshop.item.vo.ItemVO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectItemListByClass(String i_class) throws DataAccessException {
		List<ItemVO> itemList = null;
		itemList = sqlSession.selectList("mapper.item.selectItemListByClass",i_class);
		return itemList;
	}

	@Override
	public ItemVO selectItem(String itemNo) {
		return sqlSession.selectOne("mapper.item.selectItem", itemNo);
	}

}
