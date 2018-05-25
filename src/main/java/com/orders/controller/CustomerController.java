package com.orders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.entity.Customer;
import com.orders.entity.Menu;
import com.orders.entity.Window;
import com.orders.service.impl.CustomerService;
import com.orders.service.impl.MenuService;
import com.orders.service.impl.WindowService;
import com.orders.util.ResponseMessage;
import com.orders.util.ResponseMessageCodeEnum;
import com.orders.util.Result;
import com.orders.util.UUID;
import com.orders.vo.MenuVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/customer")
@Api(tags = "CustomerController")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private MenuService menuService;

	@Autowired
	private WindowService windowService;
	
	
	@ApiOperation(value = "新增顾客")
	@PostMapping(value = "/saveCustomer")
	public ResponseMessage<Customer> saveCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(UUID.randomUUID());
		customerService.insert(customer);
		return Result.success(customer);
	}
	
	
	@ApiOperation(value = "登录顾客")
	@GetMapping(value = "/loginCustomer")
	public ResponseMessage<List<MenuVo>> loginCustomer(@RequestParam(value="customerNumber") String customerNumber) {
		Customer customer=customerService.login(null, customerNumber);
		List<Window> windows=windowService.getAllWindows();
		List<MenuVo> menuVos=new ArrayList<>(windows.size());
		Menu condition=new Menu();
		List<Menu> menus=null;
		for (Window window : windows) {
			MenuVo menuVo=new MenuVo();
			condition.setWindowId(window.getWindowId());
			menus=menuService.listMenusByCondition(condition, Integer.MAX_VALUE, 1);
			menuVo.setMenus(menus);
			menuVo.setWindowId(window.getWindowId());
			menuVo.setWindowName(window.getWindowName());
			menuVos.add(menuVo);
		}
		if(customer!=null){
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),
					"登录成功",menuVos);
		}else{
			return Result.success(ResponseMessageCodeEnum.SUCCESS.getCode(),
					"登录失败",null);
		}
	}
}
