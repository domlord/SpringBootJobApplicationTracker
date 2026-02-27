package com.example.jobapplicationtracker.repository;

import com.example.jobapplicationtracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
