package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.JobPostRepository;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;


    public List<JobPost> getJobPost (){
        return jobPostRepository.findAll();
    }


    public void addJobPost (JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public Boolean updateJobPost (Integer jobPostId , JobPost jobPost){
        JobPost old = jobPostRepository.getById(jobPostId);
        if (old==null){
            return false;
        }
        old.setTitle(jobPost.getTitle());
        old.setDescription(jobPost.getDescription());
        old.setLocation(jobPost.getLocation());
        old.setSalary(jobPost.getSalary());

        jobPostRepository.save(old);
        return true;
    }


    public Boolean deleteJobPost (Integer jobPostId){
        JobPost jobPost = jobPostRepository.getById(jobPostId);
        if (jobPost==null){
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }

    public JobPost findById (Integer jobPostId){
        for(JobPost j: jobPostRepository.findAll()){
            if (j.getJobPostId().equals(jobPostId)){
                return j;
            }
        }return null;
    }



}
