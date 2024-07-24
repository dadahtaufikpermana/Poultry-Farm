package com.example.poultryfarm.service;

import com.example.poultryfarm.model.Inventory;
import com.example.poultryfarm.model.LowStockNotification;
import com.example.poultryfarm.repository.InventoryRepository;
import com.example.poultryfarm.repository.LowStockNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LowStockNotificationService {

    @Autowired
    private LowStockNotificationRepository lowStockNotificationRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public LowStockNotification saveLowStockNotification(LowStockNotification lowStockNotification) {
        return lowStockNotificationRepository.save(lowStockNotification);
    }

    public List<LowStockNotification> getAllLowStockNotifications() {
        return lowStockNotificationRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
    }
}
