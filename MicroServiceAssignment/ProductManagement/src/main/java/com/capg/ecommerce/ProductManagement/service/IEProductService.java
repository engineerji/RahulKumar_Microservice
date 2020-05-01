package com.capg.ecommerce.ProductManagement.service;

import java.util.List;

import com.capg.ecommerce.ProductManagement.entities.EProduct;

public interface IEProductService {
	EProduct fetchById(int id);
	boolean addProduct(EProduct product);
	List<EProduct> fetchAll();
}
