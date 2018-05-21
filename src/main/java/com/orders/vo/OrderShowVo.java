package com.orders.vo;

import java.util.List;

import com.orders.entity.Customer;
import com.orders.entity.Window;

public class OrderShowVo {

	/**
	 * 菜品
	 **/
	private List<MenuOrderVo> menuOrderVos;

	/**
	 * 顾客
	 **/
	private Customer customer;

	/**
	 * 窗口
	 **/
	private Window window;
	
	/**
	 * 订单总价钱
	 * **/
	private Integer totalManey;
	
	
	/**
	 * 订单号
	 * **/
	private String orderCode;
	
	
	/**
	 * 订单时间
	 * **/
	private String orderTime;
	

	public List<MenuOrderVo> getMenuOrderVos() {
		return menuOrderVos;
	}

	public void setMenuOrderVos(List<MenuOrderVo> menuOrderVos) {
		this.menuOrderVos = menuOrderVos;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
	
	
	public Integer getTotalManey() {
		return totalManey;
	}

	public void setTotalManey(Integer totalManey) {
		this.totalManey = totalManey;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
}
