package com.thinh.timemanagementservice.util;

import java.time.*;

public class DateTimeUtil {

    public static long getStartOfDayFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDate date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return convertToMillis(date.atStartOfDay());
    }

    public static long getEndOfDayFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDate date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return convertToMillis(date.atTime(LocalTime.MAX));
    }

    public static long convertToMillis(LocalDateTime dateToConvert) {
        return dateToConvert.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
