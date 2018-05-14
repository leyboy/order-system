package com.orders.entity;

public class Menu {
    private String menuId;

    private String menuName;

    private Integer menuDishPrice;

    private String windowId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
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
        this.windowId = windowId == null ? null : windowId.trim();
    }
}