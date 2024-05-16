package com.thinh.timemanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkDayDto {
    private long id;
    private long userId;
    private int typeOfPeriod;
    private long startDateTime;
    private long endDateTime;
}
