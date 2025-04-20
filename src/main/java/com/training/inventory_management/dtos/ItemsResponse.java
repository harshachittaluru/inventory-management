package com.training.inventory_management.dtos;


public class ItemsResponse<T> extends BaseResponse<T>{
	
	public ItemsResponse(boolean success, String message, T result) {
		
		super(success, message, result);
	}

}
