package com.capg.ecommerce.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.ecommerce.ProductManagement.dto.EProductDto;
import com.capg.ecommerce.ProductManagement.entities.EProduct;
import com.capg.ecommerce.ProductManagement.service.IEProductService;

@RestController
@EnableTransactionManagement
@RequestMapping("/eproducts")
public class EProductController {
	
	@Autowired
	IEProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<EProduct>> fetchAllProduct(){
		List<EProduct> list=productService.fetchAll();
		ResponseEntity<List<EProduct>> response= new ResponseEntity<List<EProduct>>(list,HttpStatus.OK);
		return response;
	}
	@PostMapping("/add")
	public ResponseEntity<EProduct> addProduct(@RequestBody EProductDto productdto){
		EProduct product = convert(productdto);
		productService.addProduct(product);
		ResponseEntity<EProduct> response= new ResponseEntity<EProduct>(product,HttpStatus.OK);
		return response;
	}
	 @GetMapping("/get/{id}")
	    public ResponseEntity<EProduct>findProductById(@PathVariable("id") int id){
	       EProduct product= productService.fetchById(id);
	       ResponseEntity<EProduct>response=new ResponseEntity<>(product,HttpStatus.OK);
	       return response;
	    }
	 public EProduct convert(EProductDto dto) {
		 EProduct product = new EProduct();
		 product.setProductId(dto.getProductId());
		 product.setProductName(dto.getProductName());
		 product.setProductPrice(dto.getProductPrice());
		 product.setItemcount(dto.getItemcount());
		 return product;
	 }
}
