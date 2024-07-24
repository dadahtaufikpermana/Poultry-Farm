package com.example.poultryfarm.controller;

import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.model.User;
import com.example.poultryfarm.service.FarmService;
import com.example.poultryfarm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Farm addFarm(@RequestBody Farm farm) {
        if (farm.getOwner() != null && farm.getOwner().getId() != null) {
            User owner = userService.findById(farm.getOwner().getId());
            farm.setOwner(owner);
        }
        return farmService.saveFarm(farm);
    }

    @GetMapping
    public List<Farm> getAllFarms() {
        return farmService.getAllFarms();
    }
}

