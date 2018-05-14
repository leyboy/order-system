package com.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Window;
import com.orders.service.impl.WindowService;
import com.orders.util.ResponseMessage;
import com.orders.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/window")
@Api(tags = "WindowController")
public class WindowController {

	@Autowired
	private WindowService windowService;
	
	
	@ApiOperation(value="按主键查询菜单窗口")
	@GetMapping(value="/{windowId}")
	public ResponseMessage<Window> getWindowById(@PathVariable String windowId){
		return Result.success(windowService.getByPrimaryKey(windowId));
	}
	
	
	
}
