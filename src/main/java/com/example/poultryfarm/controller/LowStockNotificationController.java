package com.example.poultryfarm.controller;

import com.example.poultryfarm.dto.LowStockNotificationRequest;
import com.example.poultryfarm.model.Inventory;
import com.example.poultryfarm.model.LowStockNotification;
import com.example.poultryfarm.service.LowStockNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/low-stock-notifications")
public class LowStockNotificationController {

    @Autowired
    private LowStockNotificationService lowStockNotificationService;

    @PostMapping
    public LowStockNotification addLowStockNotification(@RequestBody LowStockNotificationRequest request) {
        Inventory inventory = lowStockNotificationService.getInventoryById(request.getInventoryId());

        LowStockNotification lowStockNotification = new LowStockNotification();
        lowStockNotification.setInventory(inventory);
        lowStockNotification.setNotificationDate(request.getNotificationDate());
        lowStockNotification.setMessage(request.getMessage());

        return lowStockNotificationService.saveLowStockNotification(lowStockNotification);
    }

    @GetMapping
    public List<LowStockNotification> getAllLowStockNotifications() {
        return lowStockNotificationService.getAllLowStockNotifications();
    }
}
