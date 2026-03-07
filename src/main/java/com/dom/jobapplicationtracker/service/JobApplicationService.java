package com.dom.jobapplicationtracker.service;

import com.dom.jobapplicationtracker.controller.dto.CreateJobApplicationRequest;
import com.dom.jobapplicationtracker.controller.dto.JobApplicationResponse;
import com.dom.jobapplicationtracker.controller.dto.UpdateJobApplicationRequest;
import com.dom.jobapplicationtracker.exception.JobApplicationNotFoundException;
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
                .orElseThrow(() -> new JobApplicationNotFoundException(id));

        return mapToResponse(jobApplication);

    }

    public JobApplicationResponse update(Long id, UpdateJobApplicationRequest request) {
        JobApplication jobApplication = repository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));

        if (request.company() != null) {
            jobApplication.setCompany(request.company());
        }

        if (request.role() != null) {
            jobApplication.setRole(request.role());
        }

        if (request.location() != null) {
            jobApplication.setLocation(request.location());
        }

        if (request.salary() != null) {
            jobApplication.setSalary(request.salary());
        }

        JobApplication updated = repository.save(jobApplication);

        return mapToResponse(updated);
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
