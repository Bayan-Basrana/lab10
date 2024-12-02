package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiResponse;
import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.JobPostService;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJobPost (){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost (@RequestBody @Valid JobPost jobPost , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("JobPost added successfully"));
    }

    @PutMapping("/update/{jobPostId}")
    public ResponseEntity updateJobPost (@PathVariable Integer jobPostId ,@RequestBody @Valid JobPost jobPost ,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated = jobPostService.updateJobPost(jobPostId,jobPost);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("JobPost updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("JobPost id not found"));
    }


    @DeleteMapping("/delete/{jobPostId}")
    public ResponseEntity deleteJobPost (@PathVariable Integer jobPostId){
        Boolean isDeleted =jobPostService.deleteJobPost(jobPostId);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("JobPost Deleted successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("JobPost id not found"));
    }


}
