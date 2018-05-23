package com.orders.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Menu;
import com.orders.entity.Window;
import com.orders.service.impl.MenuService;
import com.orders.service.impl.WindowService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.util.UUID;
import com.orders.vo.MenuVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/menu")
@Api(tags = "MenuController")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private WindowService windowService;

	

	private static Logger logger = LoggerFactory.getLogger(MenuController.class);

	@ApiOperation(value = "按主键查询菜品详情")
	@GetMapping(value = "/{menuId}")
	public ResponseMessage<Menu> getMenuById(@ApiParam(value = "菜品Id") @PathVariable String menuId) {
		return Result.success(menuService.getByPrimaryKey(menuId));
	}

	@ApiOperation(value = "新增菜品")
	@PostMapping(value = "/saveMenu")
	public ResponseMessage<Menu> saveMenu(@RequestBody Menu menu) {
		menu.setMenuId(UUID.randomUUID()); // 设置主键
		menuService.insertSelective(menu);
		return Result.success(menu);
	}

	@ApiOperation(value = "修改菜品")
	@PostMapping(value = "/updateMenu")
	public ResponseMessage<Menu> updateMenu(@RequestBody Menu menu) {
		menuService.updateByPrimaryKeySelective(menu);
		return Result.success(menu);
	}

	@ApiOperation(value = "按主键删除菜品")
	@DeleteMapping(value = "/{menuId}")
	public ResponseMessage<Boolean> deleteMenuById(@PathVariable String menuId) {
		menuService.deleteByPrimaryKey(menuId);
		logger.info("删除菜品为{}", menuId);
		return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(), "删除成功", true);
	}
	
	
	
	@ApiOperation(value = "返回菜单版本")
	@GetMapping(value = "/getMenuVersion")
	public ResponseMessage<Double> getMenuVersion() {
		double menuVersion=1.1;
		return Result.success(menuVersion);
	}


	@ApiOperation(value = "按条件查询菜品")
	@GetMapping(value = {"/queryMenusByCondition"})
	public ResponseMessage<?> queryMenusByCondition(
			@ApiParam(value = "菜品名") @RequestParam(value = "menuName", required = false) String menuName) {
		Menu condition=new Menu();
		List<Menu> menus=null;
		if(menuName!=null&&(!"".equals(menuName))){
			condition.setMenuName(menuName);
			menus=menuService.listMenusByCondition(condition, Integer.MAX_VALUE, 1);
			MenuVo menuVo=new MenuVo();
			menuVo.setMenus(menus);
			if(menus!=null&&menus.size()>0){
				menuVo.setWindowId(menus.get(0).getWindowId());
				menuVo.setWindowName(windowService.getByPrimaryKey(menuVo.getWindowId()).getWindowName());
				return Result.success(menuVo);
			}else{
				return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),null,"没有查询到该名称的菜品");
			}
		}else{
			List<Window> windows=windowService.getAllWindows();
			List<MenuVo> menuVos=new ArrayList<>(windows.size());
			for (Window window : windows) {
				MenuVo menuVo=new MenuVo();
				condition.setWindowId(window.getWindowId());
				menus=menuService.listMenusByCondition(condition, Integer.MAX_VALUE, 1);
				menuVo.setMenus(menus);
				menuVo.setWindowId(window.getWindowId());
				menuVo.setWindowName(window.getWindowName());
				menuVos.add(menuVo);
			}
			return Result.success(menuVos);
		}
	}
}
