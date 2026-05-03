package com.dom.jobapplicationtracker.controller;

import com.dom.jobapplicationtracker.controller.dto.CreateJobApplicationRequest;
import com.dom.jobapplicationtracker.controller.dto.JobApplicationResponse;
import com.dom.jobapplicationtracker.controller.dto.UpdateJobApplicationRequest;
import com.dom.jobapplicationtracker.service.JobApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @Operation(summary = "Create a job application from json")
    @PostMapping
    public ResponseEntity<JobApplicationResponse> createJobApplication(@Valid @RequestBody CreateJobApplicationRequest request) {
        JobApplicationResponse response = service.createJobApplication(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "Get all stored job applications")
    @GetMapping
    public List<JobApplicationResponse> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Get job application with certain id")
    @GetMapping("/{id}")
    public JobApplicationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Update job application with certain id")
    @PatchMapping("/{id}")
    public JobApplicationResponse update( @PathVariable Long id,
            @Valid @RequestBody UpdateJobApplicationRequest request) {
        return service.update(id, request);
    }

    @Operation(summary = "Delete job application with certain id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.ok(
                Map.of("message", "job application " + id + " successfully deleted")
        );
    }

}
