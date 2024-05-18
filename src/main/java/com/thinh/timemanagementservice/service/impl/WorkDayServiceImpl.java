package com.thinh.timemanagementservice.service.impl;

import com.thinh.timemanagementservice.dto.Paging;
import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.entity.WorkDay;
import com.thinh.timemanagementservice.exception.ResourceNotFoundException;
import com.thinh.timemanagementservice.mapper.WorkDayMapper;
import com.thinh.timemanagementservice.repository.WorkDayRepository;
import com.thinh.timemanagementservice.service.WorkDayService;
import com.thinh.timemanagementservice.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkDayServiceImpl implements WorkDayService {

    private WorkDayRepository workDayRepository;

    @Override
    public WorkDayDto getWorkDayById(long id) {
        WorkDay workDay = workDayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("WorkDay", "id", id));
        return WorkDayMapper.toDto(workDay);
    }

    @Override
    public Paging<WorkDayDto> getAllWorkDay(Pageable pageable) {
        Page<WorkDay> workDays = workDayRepository.findAll(pageable);
        return new Paging<>(workDays.getContent().stream()
                .map(WorkDayMapper::toDto)
                .collect(Collectors.toList()),
                pageable,
                workDays.getTotalElements()
        );
    }

    @Override
    public Paging<WorkDayDto> getAllWorkDayByDate(Pageable pageable, long seconds) {
        val startDateTime = DateTimeUtil.getStartOfDayFromSeconds(seconds);
        val endDateTime = DateTimeUtil.getEndOfDayFromSeconds(seconds);
        System.out.println("millis = " + seconds);
        System.out.println("startDateTime = " + startDateTime);
        System.out.println("endDateTime = " + endDateTime);
        Page<WorkDay> workDays = workDayRepository.findAllByStartDateTimeBetween(startDateTime, endDateTime, pageable);
        return new Paging<>(workDays.getContent().stream()
                .map(WorkDayMapper::toDto)
                .collect(Collectors.toList()),
                pageable,
                workDays.getTotalElements()
        );
    }

    @Override
    public WorkDayDto saveWorkDay(WorkDayDto savingWorkDay) {
        WorkDay workDay = WorkDayMapper.toEntity(savingWorkDay);
        WorkDay savedWorkDay = workDayRepository.save(workDay);
        return WorkDayMapper.toDto(savedWorkDay);
    }

    @Override
    public void deleteWorkDay(long id) {
        workDayRepository.deleteById(id);
    }

    @Override
    public WorkDayDto updateWorkDay(WorkDayDto updatingWorkDay) {
        WorkDay existingWorkDay = workDayRepository.findById(updatingWorkDay.getId()).orElseThrow(() -> new ResourceNotFoundException("WorkDay", "id", updatingWorkDay.getId()));
        existingWorkDay.setTypeOfPeriod(updatingWorkDay.getTypeOfPeriod());
        existingWorkDay.setStartDateTime(updatingWorkDay.getStartDateTime());
        existingWorkDay.setEndDateTime(updatingWorkDay.getStartDateTime());
        return WorkDayMapper.toDto(workDayRepository.save(existingWorkDay));
    }
}
