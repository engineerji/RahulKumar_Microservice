package com.capg.ecommerce.CartManagement.controller;

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

import com.capg.ecommerce.CartManagement.dto.ItemDto;
import com.capg.ecommerce.CartManagement.dto.ProductDto;
import com.capg.ecommerce.CartManagement.entities.CartItem;
import com.capg.ecommerce.CartManagement.service.IItemService;

@RestController
@EnableTransactionManagement
@RequestMapping("/cartitems")
public class ItemController {
	@Autowired
	IItemService itemService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${productservice.baseurl}")
	private String baseProductServiceUrl;

	@GetMapping
	public ResponseEntity<List<CartItem>> fetchAll(){
		List<CartItem> list = itemService.fetchAll();
		ResponseEntity<List<CartItem>> response= new ResponseEntity<List<CartItem>>(list,HttpStatus.OK);
		return response;
	}
	@GetMapping("/findByUserId/{id}")
	public ResponseEntity<List<CartItem>> getItem(@PathVariable("id") String userId){
		List<CartItem> list = itemService.fetchAllByUserid(userId);
		ResponseEntity<List<CartItem>> response = new ResponseEntity<List<CartItem>>(list,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<CartItem> addItem(@PathVariable("id") int itemId){
		CartItem item = itemService.find(itemId);
		ResponseEntity<CartItem> response = new ResponseEntity<CartItem>(item,HttpStatus.OK);
		return response;
	}
	@PostMapping("/add/{pid}")
	public ResponseEntity<CartItem> addCart(@PathVariable("pid") int productId,@RequestBody ItemDto dto){
		ProductDto product = fetchProductById(productId);
		if(product!=null) {
			CartItem item = convert(dto);
			item.setItemprice(product.getProductPrice());
			itemService.addItem(item);
			ResponseEntity<CartItem> response = new ResponseEntity<CartItem>(item,HttpStatus.OK);
		return response;
		}
		return null;
	}
	public ProductDto fetchProductById(int productId) {
        String url = baseProductServiceUrl + "/get/" + productId;
        System.out.println("constructed complete url=" + url);
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        System.out.println("product id=" + productId + " product name=" + productDto.getProductName());
        return productDto;

    }
	public CartItem convert(ItemDto dto) {
		CartItem item = new CartItem();
		item.setItemId(dto.getItemId());
		item.setUserId(dto.getUserId());
		item.setItemName(dto.getItemName());
		return item;
	}
}
