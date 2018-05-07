package com.orders.entity;

public class Order {
    private Integer orderId;

    private String orderReservationTime;

    private Double orderDiscount;

    private String orderCode;

    private Byte orderDishNumber;

    private Byte orderPickNumber;

    private Integer windowId;

    private Integer menuId;

    private Integer customerId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}