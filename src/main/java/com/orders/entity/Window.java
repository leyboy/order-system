package com.orders.entity;

public class Window {
    private Integer windowId;

    private String windowName;

    private Byte windowNumber;

    public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName == null ? null : windowName.trim();
    }

    public Byte getWindowNumber() {
        return windowNumber;
    }

    public void setWindowNumber(Byte windowNumber) {
        this.windowNumber = windowNumber;
    }
}