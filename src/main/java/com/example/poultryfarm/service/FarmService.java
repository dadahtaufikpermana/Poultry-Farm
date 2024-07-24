package com.example.poultryfarm.service;

import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public Farm getFarmById(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    public Farm saveFarm(Farm farm) {
        return farmRepository.save(farm);
    }
    public Farm findById(Long id) {
        return farmRepository.findById(id).orElse(null);
    }
}
