package com.orders.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.service.impl.OrderService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.vo.OrderSaveVo;
import com.orders.vo.OrderShowVo;
import com.orders.vo.OrderVo1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/order")
@Api(tags = "OrderController")
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;

	
	@ApiOperation(value = "根据窗口Id统计每种菜品的订单数量")
	@GetMapping(value = "/getCountOrdersPerMenuDish/{windowId}")
	public ResponseMessage<List<OrderVo1>> getCountOrdersPerMenuDish(@ApiParam(value = "窗口Id") @PathVariable String windowId) {
		return Result.success(orderService.listOrderVo1s(windowId));
	}
	
	
	@ApiOperation(value = "获取顾客总订单")
	@GetMapping(value = "/getCustomerOrders/{customerId}")
	public ResponseMessage<List<OrderShowVo>> getCustomerOrders(@ApiParam(value = "顾客id") @PathVariable String customerId) {
		return Result.success(orderService.getCustomerOrdersByCustomerId(customerId));
	}
	
	
	@ApiOperation(value = "根据订单号获取订单详情")
	@GetMapping(value = "/getCustomerOrder/{orderCode}")
	public ResponseMessage<OrderShowVo> getCustomerOrderByOrderCode(@ApiParam(value = "订单号") @PathVariable String orderCode) {
		return Result.success(orderService.getCustomerOrderByOrderCode(orderCode));
	}
	
	
	@ApiOperation(value = "根据订单号获取顾客订单")
	@GetMapping(value = "/getWindowOrders/{windowId}")
	public ResponseMessage<List<OrderShowVo>> getWindowOrders(@ApiParam(value = "窗口号") @PathVariable String windowId) {
		return Result.success(orderService.getWindowOrders(windowId));
	}
	
	
	
	@ApiOperation(value = "保存顾客订单")
	@PostMapping(value = "/saveCustomerOrder")
	public ResponseMessage<String> saveCustomerOrder(@RequestBody OrderSaveVo orderVo){
		orderService.saveCustomerOrder(orderVo);
		return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),"保存订单成功");
	}
}
