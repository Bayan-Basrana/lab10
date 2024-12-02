package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public List<User> getUser (){
        return userRepository.findAll();
    }


    public void addUser (User user){
        userRepository.save(user);
    }

    public Boolean updateUser (Integer userId , User user){
        User old = userRepository.getById(userId);
        if (old==null){
            return false;
        }
        old.setName(user.getName());
        old.setPassword(user.getPassword());
        old.setEmail(user.getEmail());
        old.setAge(user.getAge());
        old.setRole(user.getRole());
        userRepository.save(old);
        return true;
    }


    public Boolean deleteUser (Integer userId){
        User user = userRepository.getById(userId);
        if (user==null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }



    public User findById (Integer userId){
        for(User u: userRepository.findAll()){
            if (u.getUserId().equals(userId)){
                return u;
            }
        }return null;
    }
}
