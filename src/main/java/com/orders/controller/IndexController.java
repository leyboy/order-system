package com.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.util.ResponseMessage;
import com.orders.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/index")
@Api(tags = "Swagger test restful")
public class IndexController {

	@ApiOperation(value="Swagger test")
	@GetMapping(value="/hello1")
	public ResponseMessage<String> index(){
		return Result.success("index");
	}
	
	@ApiOperation(value="Swagger test1")
	@GetMapping(value="/hello2")
	public ResponseMessage<String> index2(){
		return Result.success("index");
	}
}
