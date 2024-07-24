package com.example.poultryfarm.repository;

import com.example.poultryfarm.model.HealthReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthReportRepository extends JpaRepository<HealthReport, Long> {
}
