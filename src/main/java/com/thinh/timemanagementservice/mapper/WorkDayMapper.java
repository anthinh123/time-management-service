package com.thinh.timemanagementservice.mapper;

import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.entity.WorkDay;

public class WorkDayMapper {

    public static WorkDayDto toDto(WorkDay workDay) {
        return new WorkDayDto(
                workDay.getId(),
                workDay.getUserId(),
                workDay.getTypeOfPeriod(),
                workDay.getStartDateTime(),
                workDay.getEndDateTime()
        );
    }

    public static WorkDay toEntity(WorkDayDto dto) {
        return new WorkDay(
                dto.getId(),
                dto.getUserId(),
                dto.getTypeOfPeriod(),
                dto.getStartDateTime(),
                dto.getEndDateTime()
        );
    }
}
