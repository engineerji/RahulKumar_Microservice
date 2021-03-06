package com.capg.ecommerce.CartManagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartItem {

	@Id
	private int itemId;
	private String userId;
	private String itemName;
	private double itemprice;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemprice() {
		return itemprice;
	}
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", itemName=" + itemName + ", itemprice=" + itemprice
				+ "]";
	}
	
}
