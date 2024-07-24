package com.example.poultryfarm.controller;

import com.example.poultryfarm.model.PerformanceReport;
import com.example.poultryfarm.service.FarmService;
import com.example.poultryfarm.service.PerformanceReportService;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/performance-reports")
public class PerformanceReportController {

    @Autowired
    private PerformanceReportService performanceReportService;

    @Autowired
    private FarmService farmService;

    @PostMapping
    public PerformanceReport addPerformanceReport(@RequestBody PerformanceReportRequest performanceReportRequest) {
        PerformanceReport performanceReport = new PerformanceReport();
        performanceReport.setReportDate(performanceReportRequest.getReportDate());
        performanceReport.setDetails(performanceReportRequest.getDetails());
        performanceReport.setFarm(farmService.getFarmById(performanceReportRequest.getFarmId()));
        return performanceReportService.savePerformanceReport(performanceReport);
    }

    @GetMapping
    public List<PerformanceReport> getAllPerformanceReports() {
        return performanceReportService.getAllPerformanceReports();
    }
}

class PerformanceReportRequest {
    private Long farmId;
    private Date reportDate;
    private String details;

    // Getters and Setters
    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}