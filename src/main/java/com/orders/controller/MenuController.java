package com.orders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.orders.util.BeanMapper;
import com.orders.util.PageUtils;
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
	
	@Autowired
	private BeanMapper beanMapper;

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

	@SuppressWarnings("null")
	@ApiOperation(value = "按条件查询菜品")
	@GetMapping(value = "/queryMenusByCondition")
	public ResponseMessage<Map<String, Object>> queryMenusByCondition(
			@ApiParam(value = "菜品名") @RequestParam(value = "menuName", required = false) String menuName,
			@ApiParam(value = "窗口Id") @RequestParam(value = "windowId", required = true) String windowId,
			@ApiParam(value = "当前页") @RequestParam(value = "pageNum", required = false) Integer pageNum,
			@ApiParam(value = "每页记录数") @RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		Window window = windowService.getByPrimaryKey(windowId);
		map.put("currentWindow", window);
		Menu menu = new Menu();
		menu.setWindowId(windowId);
		if (menuName != null && (!"".equals(menuName))) {
			menu.setMenuName(menuName);
		}
		List<MenuVo> menuVOs = beanMapper.mapList(menuService.listMenusByCondition(menu, pageSize, pageNum), MenuVo.class);
		map.put("menuVOs", menuVOs);
		int totalCount = menuService.countMenusByCondition(menu);
		map.put("totalCount", totalCount);
		if (pageSize == null) {
			pageSize = PageUtils.DEFAULT_PER_PAGE_SIZE;
		}
		logger.info("pageNum:{},pageSize:{}",pageNum,pageSize);
		map.put("totalPages", PageUtils.getTotalPages(pageSize, totalCount));
		return Result.success(map);
	}
}
