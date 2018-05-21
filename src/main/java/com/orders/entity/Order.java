package com.orders.entity;

import java.util.Date;

public class Order {
	
    private String orderId;

    private Date orderTime;

    private String orderCode;

    private Integer orderDishNumber;

    private Integer orderPickNumber;

    private String windowId;

    private String menuId;

    private String customerId;
    
    private Integer orderState;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }



    public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getOrderDishNumber() {
        return orderDishNumber;
    }

    public void setOrderDishNumber(Integer orderDishNumber) {
        this.orderDishNumber = orderDishNumber;
    }

    public Integer getOrderPickNumber() {
        return orderPickNumber;
    }

    public void setOrderPickNumber(Integer orderPickNumber) {
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

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderTime=" + orderTime + ", orderCode=" + orderCode
				+ ", orderDishNumber=" + orderDishNumber + ", orderPickNumber=" + orderPickNumber + ", windowId="
				+ windowId + ", menuId=" + menuId + ", customerId=" + customerId + ", orderState=" + orderState + "]";
	}
}