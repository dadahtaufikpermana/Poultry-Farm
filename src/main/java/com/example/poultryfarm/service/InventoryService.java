package com.example.poultryfarm.service;

import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.model.Inventory;
import com.example.poultryfarm.model.InventoryRequest;
import com.example.poultryfarm.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private FarmService farmService;

    public Inventory saveInventory(InventoryRequest inventoryRequest) {
        Farm farm = farmService.findById(inventoryRequest.getFarmId());
        if (farm == null) {
            throw new IllegalArgumentException("Farm with ID " + inventoryRequest.getFarmId() + " not found.");
        }
        Inventory inventory = new Inventory();
        inventory.setFarm(farm);
        inventory.setItemName(inventoryRequest.getItemName());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setItemType(inventoryRequest.getItemType());
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
}


