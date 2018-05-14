package com.orders.entity;

import java.util.List;

public class Window {
	
    private String windowId;

    private String windowName;

    private Integer windowNumber;
    
    private List<Menu> menus;

    public String getWindowId() {
        return windowId;
    }

    public void setWindowId(String windowId) {
        this.windowId = windowId == null ? null : windowId.trim();
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName == null ? null : windowName.trim();
    }

	public Integer getWindowNumber() {
		return windowNumber;
	}

	public void setWindowNumber(Integer windowNumber) {
		this.windowNumber = windowNumber;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}