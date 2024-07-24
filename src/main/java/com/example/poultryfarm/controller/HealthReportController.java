package com.example.poultryfarm.controller;

import com.example.poultryfarm.dto.HealthReportDTO;
import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.model.HealthReport;
import com.example.poultryfarm.service.FarmService;
import com.example.poultryfarm.service.HealthReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-reports")
public class HealthReportController {

    @Autowired
    private HealthReportService healthReportService;

    @Autowired
    private FarmService farmService;

    @PostMapping
    public HealthReport addHealthReport(@RequestBody HealthReportDTO healthReportDTO) {
        Farm farm = farmService.getFarmById(healthReportDTO.getFarmId());
        HealthReport healthReport = new HealthReport();
        healthReport.setFarm(farm);
        healthReport.setDate(healthReportDTO.getReportDate());
        healthReport.setHealthStatus(healthReportDTO.getDescription());
        return healthReportService.saveHealthReport(healthReport);
    }

    @GetMapping
    public List<HealthReport> getAllHealthReports() {
        return healthReportService.getAllHealthReports();
    }
}
