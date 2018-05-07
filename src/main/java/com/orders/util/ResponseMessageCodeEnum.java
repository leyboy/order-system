package com.orders.util;

public enum ResponseMessageCodeEnum {
	
	SUCCESS("0"), ERROR("-1");

	private String code;

	private ResponseMessageCodeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}