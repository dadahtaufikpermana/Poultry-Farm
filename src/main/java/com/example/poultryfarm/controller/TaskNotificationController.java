package com.example.poultryfarm.controller;

import com.example.poultryfarm.dto.TaskNotificationDto;
import com.example.poultryfarm.model.TaskNotification;
import com.example.poultryfarm.service.TaskNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-notifications")
public class TaskNotificationController {

    @Autowired
    private TaskNotificationService taskNotificationService;

    @PostMapping
    public TaskNotification addTaskNotification(@RequestBody TaskNotificationDto taskNotificationDto) {
        return taskNotificationService.saveTaskNotification(taskNotificationDto);
    }

    @GetMapping
    public List<TaskNotification> getAllTaskNotifications() {
        return taskNotificationService.getAllTaskNotifications();
    }
}
