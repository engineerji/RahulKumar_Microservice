package com.capg.ecommerce.CartManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ecommerce.CartManagement.dao.ICartItemDao;
import com.capg.ecommerce.CartManagement.entities.CartItem;

@Service
@Transactional
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	ICartItemDao itemDao;
	
	@Override
	public CartItem addItem(CartItem item) {
		itemDao.save(item);
		return item;
	}

	@Override
	public CartItem find(int itemId) {
		CartItem item = itemDao.findById(itemId).get();
		return item;
	}

	@Override
	public List<CartItem> fetchAll() {
		List<CartItem> list = itemDao.findAll();
		return list;
	}

	@Override
	public List<CartItem> fetchAllByUserid(String userId) {
		List<CartItem> list = itemDao.findAllByUserId(userId);
		return list;
	}
	

}
