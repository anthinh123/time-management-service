package com.thinh.timemanagementservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TimeManagementServiceApplicationTests {

    @Test
    void contextLoads() {
        Instant expectedDate = Instant.parse("2020-09-08T12:16:40Z");
        long seconds = 1599567400L;

        Instant date = Instant.ofEpochSecond(seconds);

        assertEquals(expectedDate, date);
    }

}
