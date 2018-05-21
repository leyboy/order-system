package com.orders.vo;

/**
 *	订单菜品数量统计Vo
 * **/
public class OrderVo1 {

	private String menuName;
	
	private Integer countMenuDish;

	public String getMenuName() {
		return menuName;
	}

	public Integer getCountMenuDish() {
		return countMenuDish;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setCountMenuDish(Integer countMenuDish) {
		this.countMenuDish = countMenuDish;
	}
}
