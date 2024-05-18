package com.thinh.timemanagementservice.service;


import com.thinh.timemanagementservice.dto.Paging;
import com.thinh.timemanagementservice.dto.WorkDayDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkDayService {

    WorkDayDto getWorkDayById(long id);

    Paging<WorkDayDto> getAllWorkDay(Pageable pageable);

    Paging<WorkDayDto> getAllWorkDayByDate(Pageable pageable, long date);

    WorkDayDto saveWorkDay(WorkDayDto savingWorkDay);

    void deleteWorkDay(long id);

    WorkDayDto updateWorkDay(WorkDayDto updatingWorkDay);

}
