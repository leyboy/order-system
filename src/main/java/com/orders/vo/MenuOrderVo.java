package com.orders.vo;

/**
 * 菜品订单Vo
 * **/
public class MenuOrderVo {

	/**
	 * 菜品Id
	 * **/
	private String menuId;
	
	/**
	 * 菜品数量
	 * **/
	private Integer orderDishNumber;
	
	
	/**
	 * 菜名
	 * **/
	private String menuDishName;
	
	
	private Integer menuDishPrice;
	
	/**
	 * window窗口
	 * **/
	private String windowId;
	
	/**
	 * 窗口名
	 * **/
	private String windowName;
	
	
	public String getMenuId() {
		return menuId;
	}

	public Integer getOrderDishNumber() {
		return orderDishNumber;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setOrderDishNumber(Integer orderDishNumber) {
		this.orderDishNumber = orderDishNumber;
	}

	public String getMenuDishName() {
		return menuDishName;
	}

	public void setMenuDishName(String menuDishName) {
		this.menuDishName = menuDishName;
	}

	public Integer getMenuDishPrice() {
		return menuDishPrice;
	}

	public void setMenuDishPrice(Integer menuDishPrice) {
		this.menuDishPrice = menuDishPrice;
	}

	public String getWindowId() {
		return windowId;
	}

	public void setWindowId(String windowId) {
		this.windowId = windowId;
	}

	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	@Override
	public String toString() {
		return "MenuOrderVo [menuId=" + menuId + ", orderDishNumber=" + orderDishNumber + ", menuDishName="
				+ menuDishName + ", menuDishPrice=" + menuDishPrice + ", windowId=" + windowId + ", windowName="
				+ windowName + "]";
	} 

	
}
