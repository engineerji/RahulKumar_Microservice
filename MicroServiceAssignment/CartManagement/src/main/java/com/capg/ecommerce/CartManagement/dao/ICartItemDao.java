package com.capg.ecommerce.CartManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ecommerce.CartManagement.entities.CartItem;

public interface ICartItemDao extends JpaRepository<CartItem, Integer>{
	List<CartItem> findAllByUserId(String userId);
}
