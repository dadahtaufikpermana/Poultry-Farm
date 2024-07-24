package com.example.poultryfarm.service;

import com.example.poultryfarm.model.PerformanceReport;
import com.example.poultryfarm.repository.PerformanceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceReportService {

    @Autowired
    private PerformanceReportRepository performanceReportRepository;

    public PerformanceReport savePerformanceReport(PerformanceReport performanceReport) {
        return performanceReportRepository.save(performanceReport);
    }

    public List<PerformanceReport> getAllPerformanceReports() {
        return performanceReportRepository.findAll();
    }
}
