package com.thinh.timemanagementservice.controller;

import com.thinh.timemanagementservice.dto.SimplePage;
import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.service.WorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/workdays")
public class WorkDayController {

    private WorkDayService workDayService;

    @GetMapping
    public ResponseEntity<SimplePage<WorkDayDto>> getAllWorkDay(@PageableDefault(size = 10) final Pageable pageable) {
        return new ResponseEntity<>(workDayService.getAllWorkDay(pageable), HttpStatus.OK);
    }

    @GetMapping("{workday-id}")
    public ResponseEntity<WorkDayDto> getWorkDayById(@PathVariable("workday-id") Long id) {
        return new ResponseEntity<>(workDayService.getWorkDayById(id), HttpStatus.OK);
    }

    @GetMapping("date/{date}")
    public ResponseEntity<List<WorkDayDto>> getWorkDayByDate(@PathVariable("date") Long date) {
        return new ResponseEntity<>(workDayService.getWorkDayByDate(date), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkDayDto> saveWorkDay(@RequestBody WorkDayDto workDayDto) {
        return new ResponseEntity<>(workDayService.saveWorkDay(workDayDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WorkDayDto> updateWorkDay(@RequestBody WorkDayDto workDayDto) {
        return new ResponseEntity<>(workDayService.updateWorkDay(workDayDto), HttpStatus.OK);
    }

    @DeleteMapping("{workday-id}")
    public ResponseEntity<String> deleteWorkDay(@PathVariable("workday-id") Long id) {
        workDayService.deleteWorkDay(id);
        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
    }
}
