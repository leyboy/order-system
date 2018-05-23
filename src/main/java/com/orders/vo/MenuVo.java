package com.orders.vo;

import java.util.List;

import com.orders.entity.Menu;

public class MenuVo{

	private List<Menu> menus;
	
	private String windowId;
	
	private String windowName;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
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
}
