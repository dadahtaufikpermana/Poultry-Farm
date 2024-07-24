package com.example.poultryfarm.controller;

import com.example.poultryfarm.dto.ScheduleRequest;
import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.model.Schedule;
import com.example.poultryfarm.service.FarmService;
import com.example.poultryfarm.service.ScheduleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private FarmService farmService;

    @PostMapping
    public Schedule addSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule();
        schedule.setActivity(scheduleRequest.getActivity());
        schedule.setDate(scheduleRequest.getDate());

        Farm farm = farmService.getFarmById(scheduleRequest.getFarmId());
        schedule.setFarm(farm);

        return scheduleService.saveSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
}
