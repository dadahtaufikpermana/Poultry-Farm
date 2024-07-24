package com.example.poultryfarm.dto;

import java.util.Date;

public class LowStockNotificationRequest {
    private Long inventoryId;
    private Date notificationDate;
    private String message;

    // Getters and Setters
    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
