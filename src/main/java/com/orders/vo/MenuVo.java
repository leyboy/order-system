package com.orders.vo;

public class MenuVo {

    private String menuId;

    private String menuName;

    private Integer menuDishPrice;

	public String getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public Integer getMenuDishPrice() {
		return menuDishPrice;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuDishPrice(Integer menuDishPrice) {
		this.menuDishPrice = menuDishPrice;
	}
}
