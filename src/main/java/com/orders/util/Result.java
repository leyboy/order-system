package com.orders.util;


public class Result {
	
	@SuppressWarnings("rawtypes")
	public static ResponseMessage success() {
		return new ResponseMessage(ResponseMessageCodeEnum.SUCCESS.getCode(), "", true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResponseMessage<T> success(String code, T t) {
		return new ResponseMessage(code, "", true, t);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResponseMessage<T> success(String code, String message, T t) {
		return new ResponseMessage(code, message, true, t);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResponseMessage<T> success(T t) {
		return new ResponseMessage(ResponseMessageCodeEnum.SUCCESS.getCode(), "", true, t);
	}

	@SuppressWarnings("rawtypes")
	public static ResponseMessage error() {
		return error("");
	}

	@SuppressWarnings("rawtypes")
	public static ResponseMessage error(String message) {
		return error(ResponseMessageCodeEnum.ERROR.getCode(), message);
	}

	@SuppressWarnings("rawtypes")
	public static ResponseMessage error(String code, String message) {
		return error(code, message, (Object) null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> ResponseMessage<T> error(String code, String message, T t) {
		return new ResponseMessage(code, message, false, t);
	}
}