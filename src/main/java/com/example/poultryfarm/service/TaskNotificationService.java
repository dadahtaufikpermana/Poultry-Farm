package com.example.poultryfarm.service;

import com.example.poultryfarm.dto.TaskNotificationDto;
import com.example.poultryfarm.model.Task;
import com.example.poultryfarm.model.TaskNotification;
import com.example.poultryfarm.repository.TaskNotificationRepository;
import com.example.poultryfarm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskNotificationService {

    @Autowired
    private TaskNotificationRepository taskNotificationRepository;

    @Autowired
    private TaskRepository taskRepository;

    public TaskNotification saveTaskNotification(TaskNotificationDto taskNotificationDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskNotificationDto.getTaskId());
        if (!taskOptional.isPresent()) {
            throw new RuntimeException("Task not found with id " + taskNotificationDto.getTaskId());
        }
        
        TaskNotification taskNotification = new TaskNotification();
        taskNotification.setTask(taskOptional.get());
        taskNotification.setNotificationDate(taskNotificationDto.getNotificationDate());
        taskNotification.setMessage(taskNotificationDto.getMessage());
        
        return taskNotificationRepository.save(taskNotification);
    }

    public List<TaskNotification> getAllTaskNotifications() {
        return taskNotificationRepository.findAll();
    }
}
