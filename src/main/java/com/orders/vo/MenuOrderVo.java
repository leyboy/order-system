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
}
