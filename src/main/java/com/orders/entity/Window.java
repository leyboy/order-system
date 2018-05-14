package com.orders.entity;

public class Window {
    private String windowId;

    private String windowName;

    private Byte windowNumber;

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

    public Byte getWindowNumber() {
        return windowNumber;
    }

    public void setWindowNumber(Byte windowNumber) {
        this.windowNumber = windowNumber;
    }
}