package com.training.inventory_management.service;

import java.util.List;

import com.training.inventory_management.dtos.ItemsRequest;
import com.training.inventory_management.entities.ItemsEntity;

public interface ItemsService {
	
	public ItemsEntity addItem(ItemsRequest itemsRequest) throws Exception;
	
	public List<ItemsRequest> getAllItems();
	
	public ItemsRequest getItemById(int id);
	
	public ItemsEntity updateDetailsById(int id, String itemName, String itemCategory, Double itemPrice);

	public void deleteItemById(int id);

}
