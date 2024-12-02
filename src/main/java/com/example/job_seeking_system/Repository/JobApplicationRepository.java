package com.example.job_seeking_system.Repository;

import com.example.job_seeking_system.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {
}
