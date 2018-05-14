package com.orders.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Menu;
import com.orders.service.impl.MenuService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/menu")
@Api(tags = "MenuController")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);

	
	@ApiOperation(value="按主键查询菜品详情")
	@GetMapping(value="/{menuId}")
	public ResponseMessage<Menu> getMenuById(@PathVariable String menuId){
		return Result.success(menuService.getByPrimaryKey(menuId));
	}
	
	
	@ApiOperation(value="新增菜品")
	@PostMapping(value="/saveMenu")
	public ResponseMessage<Menu> saveMenu(@RequestBody Menu menu){
		menu.setMenuId(UUID.randomUUID()); //设置主键
		menuService.insertSelective(menu);
		return Result.success(menu);
	}
	
	
	@ApiOperation(value="修改菜品")
	@PostMapping(value="/updateMenu")
	public ResponseMessage<Menu> updateMenu(@RequestBody Menu menu){
		menuService.updateByPrimaryKeySelective(menu);
		return Result.success(menu);
	}
	
	
	
	@ApiOperation(value="按主键删除菜品")
	@DeleteMapping(value="/{menuId}")
	public ResponseMessage<Boolean> deleteMenuById(@PathVariable String menuId){
		menuService.deleteByPrimaryKey(menuId);
		logger.info("删除菜品为{}",menuId);
		return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),
				"删除成功",true);
	}
	
	
	
}
