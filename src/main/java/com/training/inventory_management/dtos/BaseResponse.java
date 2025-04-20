package com.training.inventory_management.dtos;

public class BaseResponse<T> {

	
	private boolean success;
	
	private String message;
	
	private T result;

	public BaseResponse() {
	}
	
	public BaseResponse(boolean success, String message, T result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	
}
