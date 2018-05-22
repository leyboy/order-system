package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseMessage<List<OrderVo1>> getCountOrdersPerMenuDish(
			@ApiParam(value = "窗口Id") @PathVariable String windowId) {
		return Result.success(orderService.listOrderVo1s(windowId));
	}


	@ApiOperation(value = "获取顾客总订单号")
	@GetMapping(value = "/getCustomerOrderCodes/{customerId}")
	public ResponseMessage<List<String>> getCustomerOrderCodes(
			@ApiParam(value = "顾客id") @PathVariable String customerId) {
		// return
		// Result.success(orderService.getCustomerOrdersByCustomerId(customerId));
		return Result.success(orderService.getCustomerOrWindowOrderCodes(customerId, null));
	}

	@ApiOperation(value = "获取窗口总订单号")
	@GetMapping(value = "/getWindowOrderCodes/{windowId}")
	public ResponseMessage<List<String>> getWindowOrderCodes(@ApiParam(value = "窗口id") @PathVariable String windowId) {
		// return
		// Result.success(orderService.getCustomerOrdersByCustomerId(customerId));
		return Result.success(orderService.getCustomerOrWindowOrderCodes(null, windowId));
	}

	@ApiOperation(value = "根据订单号获取订单详情")
	@GetMapping(value = "/getCustomerOrWindowOrder")
	public ResponseMessage<OrderShowVo> getCustomerOrderByOrderCode(
			@ApiParam(value = "订单号") @RequestParam(required = false) String orderCode,
			@ApiParam(value = "顾客Id") @RequestParam(required = false) String customerId,
			@ApiParam(value = "窗口Id") @RequestParam(required = false) String windowId) {
		if (customerId != null && customerId != "") {
			return Result.success(orderService.getCustomerOrderByOrderCode(orderCode, customerId, null));
		} else {
			return Result.success(orderService.getCustomerOrderByOrderCode(orderCode, null, windowId));
		}
	}
	
	@ApiOperation(value = "获取顾客总订单")
	@GetMapping(value = "/getCustomerOrders/{customerId}")
	public ResponseMessage<List<OrderShowVo>> getCustomerOrders(
			@ApiParam(value = "顾客id") @PathVariable String customerId) {
		// return
		// Result.success(orderService.getCustomerOrdersByCustomerId(customerId));
		return Result.success(orderService.getCustomerOrWindowOrderShowVos(customerId, null));
	}

	@ApiOperation(value = "获取窗口的总订单")
	@GetMapping(value = "/getWindowOrders/{windowId}")
	public ResponseMessage<List<OrderShowVo>> getWindowOrders(@ApiParam(value = "窗口号") @PathVariable String windowId) {
		return Result.success(orderService.getCustomerOrWindowOrderShowVos(null, windowId));
	}

	@ApiOperation(value = "保存顾客订单")
	@PostMapping(value = "/saveCustomerOrder")
	public ResponseMessage<String> saveCustomerOrder(@RequestBody OrderSaveVo orderVo) {
		orderService.saveCustomerOrder(orderVo);
		return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(), "保存订单成功");
	}
}
