package com.example.poultryfarm.repository;

import com.example.poultryfarm.model.PerformanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceReportRepository extends JpaRepository<PerformanceReport, Long> {
}
