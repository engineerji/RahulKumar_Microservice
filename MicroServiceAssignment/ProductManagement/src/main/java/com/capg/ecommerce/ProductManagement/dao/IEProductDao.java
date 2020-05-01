package com.capg.ecommerce.ProductManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ecommerce.ProductManagement.entities.EProduct;

@Repository
public interface IEProductDao extends JpaRepository<EProduct, Integer>{

}
