package com.thinh.timemanagementservice.repository;

import com.thinh.timemanagementservice.entity.WorkDay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
    Page<WorkDay> findAll(Pageable pageable);

    @Query(
            value = "SELECT * FROM workdays WHERE start_date_time BETWEEN ?1 AND ?2 AND end_date_time BETWEEN ?1 AND ?2",
            countQuery = "SELECT count(*) FROM workdays",
            nativeQuery = true)
    Page<WorkDay> findAllByStartDateTimeBetween(long startDateTime, long endDateTime, Pageable pageable);
}