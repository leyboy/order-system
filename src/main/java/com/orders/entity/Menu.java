package com.orders.entity;

public class Menu {
    private Integer menuId;

    private String menuName;

    private Integer menuDishPrice;

    private Integer windowId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }
}