package com.example.poultryfarm.dto;

import java.util.Date;

public class HealthReportDTO {

    private Long farmId;
    private Date reportDate;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
