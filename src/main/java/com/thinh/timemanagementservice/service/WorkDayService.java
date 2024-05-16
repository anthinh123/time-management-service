package com.thinh.timemanagementservice.service;


import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.entity.WorkDay;

import java.util.List;

public interface WorkDayService {

    WorkDayDto getWorkDayById(long id);

    List<WorkDayDto> getAllWorkDay();

    WorkDayDto saveWorkDay(WorkDayDto savingWorkDay);

    void deleteWorkDay(long id);

    List<WorkDayDto> getWorkDayByDate(long date);

    WorkDayDto updateWorkDay(WorkDayDto updatingWorkDay);

}
