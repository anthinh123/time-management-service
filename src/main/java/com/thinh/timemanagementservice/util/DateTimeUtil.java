package com.thinh.timemanagementservice.util;

import java.time.*;

public class DateTimeUtil {

    public static long getStartOfDayFromSeconds(long seconds) {
        Instant instant = Instant.ofEpochSecond(seconds);
        LocalDate date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println("start of day: " + date.atStartOfDay());
        return convertToSeconds(date.atStartOfDay());
    }

    public static long getEndOfDayFromSeconds(long seconds) {
        Instant instant = Instant.ofEpochSecond(seconds);
        LocalDate date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println("end of day: " + date.atTime(LocalTime.MAX));
        return convertToSeconds(date.atTime(LocalTime.MAX));
    }

    public static long convertToSeconds(LocalDateTime dateToConvert) {
        return dateToConvert.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }
}
