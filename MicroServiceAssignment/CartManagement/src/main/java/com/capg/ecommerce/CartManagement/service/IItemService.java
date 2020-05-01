package com.capg.ecommerce.CartManagement.service;

import java.util.List;

import com.capg.ecommerce.CartManagement.entities.CartItem;

public interface IItemService {

	CartItem addItem(CartItem item);
	CartItem find(int itemId);
	List<CartItem> fetchAll();
	List<CartItem> fetchAllByUserid(String userId);
}
