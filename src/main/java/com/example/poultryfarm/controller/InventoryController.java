package com.example.poultryfarm.controller;

import com.example.poultryfarm.model.Inventory;
import com.example.poultryfarm.model.InventoryRequest;
import com.example.poultryfarm.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public Inventory addInventory(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.saveInventory(inventoryRequest);
    }

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }
}

