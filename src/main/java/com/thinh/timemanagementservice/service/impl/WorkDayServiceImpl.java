package com.thinh.timemanagementservice.service.impl;

import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.entity.WorkDay;
import com.thinh.timemanagementservice.exception.ResourceNotFoundException;
import com.thinh.timemanagementservice.mapper.WorkDayMapper;
import com.thinh.timemanagementservice.repository.WorkDayRepository;
import com.thinh.timemanagementservice.service.WorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<WorkDayDto> getAllWorkDay() {
        List<WorkDay> workDays = workDayRepository.findAll();
        return workDays.stream().map(WorkDayMapper::toDto).collect(Collectors.toList());
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
    public List<WorkDayDto> getWorkDayByDate(long date) {
        // TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet");
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
