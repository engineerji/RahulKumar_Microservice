package com.capg.ecommerce.CartManagement.dto;

public class ProductDto {
	private int productId;
	private String productName;
	private double productPrice;
	private int itemcount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getItemcount() {
		return itemcount;
	}
	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}
}
