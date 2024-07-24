package com.example.poultryfarm.service;

import com.example.poultryfarm.model.HealthReport;
import com.example.poultryfarm.repository.HealthReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthReportService {

    @Autowired
    private HealthReportRepository healthReportRepository;

    public HealthReport saveHealthReport(HealthReport healthReport) {
        return healthReportRepository.save(healthReport);
    }

    public List<HealthReport> getAllHealthReports() {
        return healthReportRepository.findAll();
    }
}
