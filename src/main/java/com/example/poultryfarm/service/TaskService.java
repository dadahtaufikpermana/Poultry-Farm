package com.example.poultryfarm.service;

import com.example.poultryfarm.dto.TaskDto;
import com.example.poultryfarm.model.Farm;
import com.example.poultryfarm.model.Task;
import com.example.poultryfarm.model.TaskNotification;
import com.example.poultryfarm.model.User;
import com.example.poultryfarm.repository.FarmRepository;
import com.example.poultryfarm.repository.TaskNotificationRepository;
import com.example.poultryfarm.repository.TaskRepository;
import com.example.poultryfarm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskNotificationRepository taskNotificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FarmRepository farmRepository;

    public Task saveTask(TaskDto taskDto) {
        User assignee = userRepository.findById(taskDto.getAssigneeId())
                .orElseThrow(() -> new RuntimeException("Assignee not found with id " + taskDto.getAssigneeId()));
        Farm farm = farmRepository.findById(taskDto.getFarmId())
                .orElseThrow(() -> new RuntimeException("Farm not found with id " + taskDto.getFarmId()));
        
        Task task = new Task();
        task.setAssignee(assignee);
        task.setFarm(farm);
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(taskDto.getStatus());
        
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
     public List<TaskNotification> getTaskNotifications(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found with id " + taskId));
        return taskNotificationRepository.findByTask(task);
    }
}
