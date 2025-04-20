package com.training.inventory_management.dtos;

import com.training.inventory_management.entities.ItemsEntity;

public class ItemsRequest {
	
	private String itemName;
	
	private String itemCategory;
	
	private double itemPrice;
	
	public ItemsRequest() {
		
	}
	
	public ItemsRequest(ItemsEntity itemsEntity) {
		this.itemCategory = itemsEntity.getItemCategory();
		this.itemName = itemsEntity.getItemName();
		this.itemPrice = itemsEntity.getItemPrice();
	}

	public ItemsRequest(String itemName, String itemCategory, double itemPrice) {
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
