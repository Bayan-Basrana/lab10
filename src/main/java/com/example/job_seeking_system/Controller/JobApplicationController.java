package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiResponse;
import com.example.job_seeking_system.Model.JobApplication;
import com.example.job_seeking_system.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobApplication")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService ;


    @GetMapping("/get")
    public ResponseEntity getJobApplication (){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }

@PostMapping("/applyForJob")
    public ResponseEntity applyForJob (@RequestBody JobApplication jobApplication){
        Integer result = jobApplicationService.applyForJob(jobApplication);
    if (result==1){
        return ResponseEntity.status(400).body(new ApiResponse("JobPost Id not found"));
    }
        if (result==3){
            return ResponseEntity.status(400).body(new ApiResponse("User Id not found"));
        }
    return ResponseEntity.status(200).body(new ApiResponse("applyForJob successfully"));
    }
@DeleteMapping("/withdraw/{id}")
    public ResponseEntity Withdraw (@PathVariable Integer id ){
        Boolean isDeleted =jobApplicationService.Withdraw(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("JobApplication deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("JobApplication id not found"));
    }



}
