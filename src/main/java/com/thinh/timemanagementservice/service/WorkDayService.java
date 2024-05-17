package com.thinh.timemanagementservice.service;


import com.thinh.timemanagementservice.dto.SimplePage;
import com.thinh.timemanagementservice.dto.WorkDayDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkDayService {

    WorkDayDto getWorkDayById(long id);

    SimplePage<WorkDayDto> getAllWorkDay(Pageable pageable);

    WorkDayDto saveWorkDay(WorkDayDto savingWorkDay);

    void deleteWorkDay(long id);

    List<WorkDayDto> getWorkDayByDate(long date);

    WorkDayDto updateWorkDay(WorkDayDto updatingWorkDay);

}
