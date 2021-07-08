package com.chandra.rest;

public class Bean  {

	private String message;

	public Bean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Bean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
