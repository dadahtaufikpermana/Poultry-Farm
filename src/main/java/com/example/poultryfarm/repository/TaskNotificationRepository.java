package com.example.poultryfarm.repository;

import com.example.poultryfarm.model.Task;
import com.example.poultryfarm.model.TaskNotification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskNotificationRepository extends JpaRepository<TaskNotification, Long> {
    List<TaskNotification> findByTask(Task task);
}
