package com.orders.vo;

import java.util.List;

public class OrderShowVo {

	/**
	 * 菜品
	 **/
	private List<MenuOrderVo> menuOrderVos;

	/**
	 * 顾客姓名
	 **/
	private String customerName;
	
	/**
	 * 顾客学号
	 * **/
	private String customerNumber;

	/**
	 * 窗口
	 **/
	private String windowName;
	
	
	private Integer orderPickNumber;
	
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getWindowName() {
		return windowName;
	}


	public void setWindowName(String windowName) {
		this.windowName = windowName;
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


	public Integer getOrderPickNumber() {
		return orderPickNumber;
	}


	public void setOrderPickNumber(Integer orderPickNumber) {
		this.orderPickNumber = orderPickNumber;
	}
}
