package com.example.poultryfarm.repository;

import com.example.poultryfarm.model.LowStockNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowStockNotificationRepository extends JpaRepository<LowStockNotification, Long> {
}
