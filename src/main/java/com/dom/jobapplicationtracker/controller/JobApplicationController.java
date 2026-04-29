package com.dom.jobapplicationtracker.controller;

import com.dom.jobapplicationtracker.controller.dto.CreateJobApplicationRequest;
import com.dom.jobapplicationtracker.controller.dto.JobApplicationResponse;
import com.dom.jobapplicationtracker.controller.dto.UpdateJobApplicationRequest;
import com.dom.jobapplicationtracker.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobApplicationResponse> createJobApplication(@Valid @RequestBody CreateJobApplicationRequest request) {
        JobApplicationResponse response = service.createJobApplication(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<JobApplicationResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public JobApplicationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public JobApplicationResponse update( @PathVariable Long id,
            @Valid @RequestBody UpdateJobApplicationRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
