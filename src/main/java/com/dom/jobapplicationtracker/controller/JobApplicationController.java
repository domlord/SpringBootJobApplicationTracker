package com.dom.jobapplicationtracker.controller;

import com.dom.jobapplicationtracker.controller.dto.CreateJobApplicationRequest;
import com.dom.jobapplicationtracker.controller.dto.JobApplicationResponse;
import com.dom.jobapplicationtracker.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobapplication")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobApplicationResponse> createJobApplication(
            CreateJobApplicationRequest
    )
}
