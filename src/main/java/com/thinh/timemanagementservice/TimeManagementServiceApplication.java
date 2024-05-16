package com.thinh.timemanagementservice;

import com.thinh.timemanagementservice.mapper.WorkDayMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimeManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeManagementServiceApplication.class, args);
	}

}
