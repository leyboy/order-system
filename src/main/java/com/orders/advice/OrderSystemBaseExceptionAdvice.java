package com.orders.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.orders.exception.OrderSystemBaseException;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;

/**
 * 订单系统基本异常通知
 * **/
@ControllerAdvice
@Order(value = 1)
public class OrderSystemBaseExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(OrderSystemBaseExceptionAdvice.class);

    @SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(OrderSystemBaseException.class)
    @ResponseBody
    public ResponseMessage handlerOrderSystemBaseException(OrderSystemBaseException exception) {
        logger.warn(exception.getMessage(), exception);
        return Result.error(exception.getErrorCode(), exception.getMessage());
    }
    
    @SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage handlerOrderSystemBaseException(Exception exception) {
        logger.error(exception.getMessage(), exception);
        // TODO 在数据库中记录程序异常，这个地方的异常是未处理的异常，需要管理员查看并进行处理以防重复出现
        return Result.error(ResponseMessageCodeEnum.ERROR.getCode(), "程序异常，请重试。如果重复出现请联系管理员处理！");
    }
}
