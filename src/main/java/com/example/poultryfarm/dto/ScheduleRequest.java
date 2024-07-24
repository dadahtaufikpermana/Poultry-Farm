package com.example.poultryfarm.dto;

import java.util.Date;

public class ScheduleRequest {
    private Long farmId;
    private String activity;
    private Date date;

    // Getters and Setters
    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
