package com.capg.ecommerce.ProductManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ecommerce.ProductManagement.dao.IEProductDao;
import com.capg.ecommerce.ProductManagement.entities.EProduct;

@Service
@Transactional
public class EProductServiceImpl implements IEProductService{

	@Autowired
	IEProductDao productDao;
	@Override
	public EProduct fetchById(int id) {
		Optional<EProduct> option=productDao.findById(id);
		EProduct product=null;
		if(option.isPresent()) {
			product =option.get();
		}
		return product;
	}

	@Override
	public boolean addProduct(EProduct product) {
		productDao.save(product);
		return true;
	}

	@Override
	public List<EProduct> fetchAll() {
		List<EProduct> productList = productDao.findAll();
		return productList;
	}

}
