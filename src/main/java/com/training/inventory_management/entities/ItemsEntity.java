package com.training.inventory_management.entities;

import com.training.inventory_management.dtos.ItemsRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class ItemsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "item_name")
	@NotNull
	private String itemName;
	
	@Column(name = "item_category")
	@NotNull
	private String itemCategory;
	
	@Column(name = "item_price")
	@NotNull
	private double itemPrice;
	
	public ItemsEntity() {}
	
	public ItemsEntity(ItemsRequest itemsRequest) {
		this.itemName = itemsRequest.getItemName();
		this.itemCategory = itemsRequest.getItemCategory();
		this.itemPrice = itemsRequest.getItemPrice();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
