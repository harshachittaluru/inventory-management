package com.training.inventory_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.inventory_management.dtos.ItemsRequest;
import com.training.inventory_management.dtos.ItemsResponse;
import com.training.inventory_management.entities.ItemsEntity;
import com.training.inventory_management.service.ItemsService;

@RestController
@RequestMapping("items")
public class ItemController {
	
	private ItemsService itemsService;
	
	@Autowired
	public ItemController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@PostMapping("/addItem")
	public ResponseEntity<ItemsResponse<ItemsEntity>> addItem(@RequestBody ItemsRequest itemsRequest) {
	    ItemsEntity itemsEntity;
	    try {
	        itemsEntity = this.itemsService.addItem(itemsRequest);
	    } catch (Exception e) {
	        ItemsResponse<ItemsEntity> errorResponse = new ItemsResponse<>(false, e.getMessage(), null);
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    ItemsResponse<ItemsEntity> itemsResponse = new ItemsResponse<>(true, "Item added successfully!", itemsEntity);
	    return new ResponseEntity<>(itemsResponse, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<ItemsResponse<List<ItemsRequest>>> getItems(){
		List<ItemsRequest> items = this.itemsService.getAllItems();
		ItemsResponse<List<ItemsRequest>> itemsResponse = new ItemsResponse<>(true, "Items Fetched Successfully!", items);
		return new ResponseEntity<>(itemsResponse, HttpStatus.FOUND);
	}
	
	@GetMapping("/getItem/{id}")
	public ResponseEntity<ItemsResponse<ItemsRequest>> getItemById(@PathVariable int id){
		try {
		    ItemsRequest item = this.itemsService.getItemById(id);
		    ItemsResponse<ItemsRequest> itemsResponse = new ItemsResponse<>(true, "Items Fetched Successfully!", item);
			return new ResponseEntity<>(itemsResponse, HttpStatus.FOUND);
		} catch (RuntimeException e) {
		    ItemsResponse<ItemsRequest> errorResponse = new ItemsResponse<>(false, e.getMessage(), null);
		    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateItem/{id}")
	public ResponseEntity<ItemsResponse<ItemsEntity>> updateDetailsById(@PathVariable int id,
			@RequestParam(required = false) String itemName, @RequestParam(required = false) String itemCategory,
			@RequestParam(required = false) Double itemPrice) {
		ItemsEntity itemsEntity;
		try {
			itemsEntity = this.itemsService.updateDetailsById(id, itemName, itemCategory, itemPrice);
		} catch (Exception e) {
			ItemsResponse<ItemsEntity> errorResponse = new ItemsResponse<>(false, e.getMessage(), null);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		ItemsResponse<ItemsEntity> itemsResponse = new ItemsResponse<>(true, "Item updated successfully!", itemsEntity);
		return new ResponseEntity<>(itemsResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<ItemsResponse<Integer>> deleteItemById(@PathVariable int id) {
		try {
			this.itemsService.deleteItemById(id);
			ItemsResponse<Integer> itemsResponse = new ItemsResponse<>(true, "Items Deleted Successfully!", id);
			return new ResponseEntity<>(itemsResponse, HttpStatus.OK);
		} catch (RuntimeException e) {
			ItemsResponse<Integer> errorResponse = new ItemsResponse<>(false, e.getMessage(), null);
			return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	
}
