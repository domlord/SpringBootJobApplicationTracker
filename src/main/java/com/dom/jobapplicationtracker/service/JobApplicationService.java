package com.dom.jobapplicationtracker.service;

import com.dom.jobapplicationtracker.controller.dto.CreateJobApplicationRequest;
import com.dom.jobapplicationtracker.controller.dto.JobApplicationResponse;
import com.dom.jobapplicationtracker.model.JobApplication;
import com.dom.jobapplicationtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplicationResponse createJobApplication(CreateJobApplicationRequest request) {
        JobApplication jobApplication = JobApplication.builder()
                .company(request.company())
                .role(request.role())
                .location(request.location())
                .salary(request.salary())
                .build();

        JobApplication saved = repository.save(jobApplication);

        return mapToResponse(saved);

    }

    public List<JobApplicationResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public JobApplicationResponse getById(Long id) {
        JobApplication jobApplication = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job application not found"));

        return mapToResponse(jobApplication);

    }

    private JobApplicationResponse mapToResponse(JobApplication jobApplication) {
        return new JobApplicationResponse(
                jobApplication.getId(),
                jobApplication.getCompany(),
                jobApplication.getRole(),
                jobApplication.getLocation(),
                jobApplication.getSalary()
        );
    }

}
