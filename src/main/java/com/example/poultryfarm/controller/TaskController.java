package com.example.poultryfarm.controller;

import com.example.poultryfarm.dto.TaskDto;
import com.example.poultryfarm.model.Task;
import com.example.poultryfarm.model.TaskNotification;
import com.example.poultryfarm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody TaskDto taskDto) {
        return taskService.saveTask(taskDto);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}/notifications")
    public List<TaskNotification> getTaskNotifications(@PathVariable Long taskId) {
        return taskService.getTaskNotifications(taskId);
    }
}
