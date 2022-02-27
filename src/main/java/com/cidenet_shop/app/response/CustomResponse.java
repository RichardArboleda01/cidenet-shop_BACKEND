package com.cidenet_shop.app.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomResponse {
	
	private String code;
	private String message;
	private int status;
	private int totalObject;
	private Object ObjectResponse;
	
	
	public CustomResponse(String message, HttpStatus status) {
		this.message = message;
		this.status = status.value();
		this.code = status.name();
	}
	

	public int getTotalObject() {
		return totalObject;
	}



	public void setTotalObject(int totalObject) {
		this.totalObject = totalObject;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getObjectResponse() {
		return ObjectResponse;
	}

	public void setObjectResponse(Object objectResponse) {
		ObjectResponse = objectResponse;
	}
	
}
