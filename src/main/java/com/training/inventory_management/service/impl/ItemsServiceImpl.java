package com.training.inventory_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.inventory_management.dtos.ItemsRequest;
import com.training.inventory_management.entities.ItemsEntity;
import com.training.inventory_management.repo.ItemsRepository;
import com.training.inventory_management.service.ItemsService;

import jakarta.transaction.Transactional;

@Service
public class ItemsServiceImpl implements ItemsService{
	
	private ItemsRepository itemsRepository;
	
	
	@Autowired
	public ItemsServiceImpl(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}

	@Override
	@Transactional
	public ItemsEntity addItem(ItemsRequest itemsRequest) throws Exception {
		ItemsEntity itemsEntity = new ItemsEntity(itemsRequest);
		itemsEntity = this.itemsRepository.save(itemsEntity);
		return itemsEntity;
	}

	@Override
	public List<ItemsRequest> getAllItems() {
		
		List<ItemsEntity> itemsEntities = this.itemsRepository.findAll();
		List<ItemsRequest> items = itemsEntities.stream().map(ItemsRequest::new).collect(Collectors.toList());
		
		return items;
	}

	@Override
	public ItemsRequest getItemById(int id) {
		
		ItemsEntity itemsEntity = this.itemsRepository.findById(id)
				.orElseThrow(() ->  new RuntimeException("Item not found by Id: "+id));
		
		return new ItemsRequest(itemsEntity);
	}

	@Override
	public ItemsEntity updateDetailsById(int id, String itemName, String itemCategory, Double itemPrice) {
		ItemsEntity item = this.itemsRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Item not found by id: " + id));
		
		if (itemName != null && !itemName.isEmpty())
			item.setItemName(itemName);
		if (itemCategory != null && !itemCategory.isEmpty())
			item.setItemCategory(itemCategory);
		if (itemPrice != null && itemPrice != item.getItemPrice())
			item.setItemPrice(itemPrice.doubleValue());
	    return this.itemsRepository.save(item);
	}

	@Override
	public void deleteItemById(int id) {
		ItemsEntity item = this.itemsRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Item not found by id: " + id));

		this.itemsRepository.delete(item);
	}

}
