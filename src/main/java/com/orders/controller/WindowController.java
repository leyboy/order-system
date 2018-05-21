package com.orders.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Window;
import com.orders.service.impl.WindowService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.util.UUID;

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
	
	
	@ApiOperation(value = "新增窗口")
	@PostMapping(value = "/saveWindow")
	public ResponseMessage<Window> saveWindow(@RequestBody Window window) {
		window.setWindowId(UUID.randomUUID()); // 设置主键
		windowService.insertSelective(window);
		return Result.success(window);
	}
	
	
	@ApiOperation(value = "登录窗口")
	@PostMapping(value = "/login/{windowName}")
	public ResponseMessage<Window> loginWindow(@PathVariable String windowName) {
		Window window=windowService.loginWindow(windowName);
		if(window==null){
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),"登录失败",null);
		}else{
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),"登录成功",window);
		}
	}
}
