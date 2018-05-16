package com.orders.exception;

/**
 * 订单系统基本异常
 **/
public class OrderSystemBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 **/
	private String errorCode;

	public OrderSystemBaseException(String message) {
		this("-1", message);
	}

	public OrderSystemBaseException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
