package com.orders.vo;

import java.util.List;

import com.orders.entity.Order;
import com.orders.util.DateUtils;

public class OrderSaveVo extends Order {
	
	/**
	 * 订单展示时间
	 * **/
	private String orderTimeShow;
	
	/**
	 * 顾客号
	 * **/
	private String customerNumber;
	
	/**
	 * 菜品集合
	 * **/
	private List<MenuOrderVo> menuOrderVos;


	public List<MenuOrderVo> getMenuOrderVos() {
		return menuOrderVos;
	}

	
	public void setMenuOrderVos(List<MenuOrderVo> menuOrderVos) {
		this.menuOrderVos = menuOrderVos;
	}


	public String getOrderTimeShow() {
		this.orderTimeShow=DateUtils.dateToString(this.getOrderTime(), DateUtils.yyyy_MM_dd_HH_mm_ss_EN);
		return orderTimeShow;
	}


	public void setOrderTimeShow(String orderTimeShow) {
		this.orderTimeShow = orderTimeShow;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
}
