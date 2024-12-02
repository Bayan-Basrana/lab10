package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.JobApplication;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.JobApplicationRepository;
import com.example.job_seeking_system.Repository.JobPostRepository;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserService userService;
    private final JobPostService jobPostService;


    public List<JobApplication> getJobApplication (){
        return jobApplicationRepository.findAll();
    }

    public Integer applyForJob (  JobApplication jobApplication){
        if (userService.findById(jobApplication.getUserId())!=null){
            if(jobPostService.findById(jobApplication.getJobPostId())==null){
                return 1;
            }
            jobApplicationRepository.save(jobApplication);
            return 2;
        }return 3;
    }

    public Boolean Withdraw (Integer id){
        JobApplication jobApplication= jobApplicationRepository.getById(id);
        if (jobApplication==null){
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

}
