package com.thinh.timemanagementservice.controller;

import com.thinh.timemanagementservice.dto.Paging;
import com.thinh.timemanagementservice.dto.WorkDayDto;
import com.thinh.timemanagementservice.service.WorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/workdays")
public class WorkDayController {

    private WorkDayService workDayService;

    @GetMapping
    public ResponseEntity<Paging<WorkDayDto>> getAllWorkDay(@PageableDefault final Pageable pageable) {
        return new ResponseEntity<>(workDayService.getAllWorkDay(pageable), HttpStatus.OK);
    }

    @GetMapping("{workday-id}")
    public ResponseEntity<WorkDayDto> getWorkDayById(@PathVariable("workday-id") Long id) {
        return new ResponseEntity<>(workDayService.getWorkDayById(id), HttpStatus.OK);
    }

    @GetMapping("date/{date}")
    public ResponseEntity<Paging<WorkDayDto>> getWorkDayByDate(@PathVariable("date") Long date, @PageableDefault final Pageable pageable) {
        return new ResponseEntity<>(workDayService.getAllWorkDayByDate(pageable, date), HttpStatus.OK);
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
