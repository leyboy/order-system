package com.orders.entity;

public class Order {
    private String orderId;

    private String orderReservationTime;

    private Double orderDiscount;

    private String orderCode;

    private Byte orderDishNumber;

    private Byte orderPickNumber;

    private String windowId;

    private String menuId;

    private String customerId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderReservationTime() {
        return orderReservationTime;
    }

    public void setOrderReservationTime(String orderReservationTime) {
        this.orderReservationTime = orderReservationTime == null ? null : orderReservationTime.trim();
    }

    public Double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Byte getOrderDishNumber() {
        return orderDishNumber;
    }

    public void setOrderDishNumber(Byte orderDishNumber) {
        this.orderDishNumber = orderDishNumber;
    }

    public Byte getOrderPickNumber() {
        return orderPickNumber;
    }

    public void setOrderPickNumber(Byte orderPickNumber) {
        this.orderPickNumber = orderPickNumber;
    }

    public String getWindowId() {
        return windowId;
    }

    public void setWindowId(String windowId) {
        this.windowId = windowId == null ? null : windowId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }
}