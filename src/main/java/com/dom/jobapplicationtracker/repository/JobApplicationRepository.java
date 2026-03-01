package com.dom.jobapplicationtracker.repository;

import com.dom.jobapplicationtracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
