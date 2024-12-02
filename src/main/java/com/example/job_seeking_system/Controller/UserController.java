package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiResponse;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.UserRepository;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser (){
        return ResponseEntity.status(200).body(userService.getUser());
    }

@PostMapping("/add")
    public ResponseEntity addUser (@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
return ResponseEntity.status(200).body(new ApiResponse("user added successfully"));
    }

@PutMapping("/update/{userId}")
    public ResponseEntity updateUser (@PathVariable Integer userId ,@RequestBody @Valid User user ,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated = userService.updateUser(userId,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("user updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("userId not found"));
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser (@PathVariable Integer userId){
        Boolean isDeleted =userService.deleteUser(userId);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user Deleted successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("user id not found"));
    }

}
