package com.thinh.timemanagementservice.repository;

import com.thinh.timemanagementservice.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
}