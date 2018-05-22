package com.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Customer;
import com.orders.service.impl.CustomerService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/customer")
@Api(tags = "CustomerController")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@ApiOperation(value = "新增顾客")
	@PostMapping(value = "/saveCustomer")
	public ResponseMessage<Customer> saveCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(UUID.randomUUID());
		customerService.insert(customer);
		return Result.success(customer);
	}
	
	
	@ApiOperation(value = "登录顾客")
	@PostMapping(value = "/loginCustomer")
	public ResponseMessage<Boolean> loginCustomer(@RequestParam String customerNumber) {
		boolean isLogin=customerService.login(null, customerNumber);
		if(isLogin){
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),
					"登录成功",isLogin);
		}else{
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),
					"登录失败",isLogin);
		}
	}
}
