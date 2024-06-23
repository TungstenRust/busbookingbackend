package com.example.busbookingbackend.service;

import com.example.busbookingbackend.dto.LoginRequest;
import com.example.busbookingbackend.dto.SignupRequest;
import com.example.busbookingbackend.entity.Users;
import com.example.busbookingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;
    public Users GetUserByUsername(LoginRequest loginRequest) {
        var user = userRepository.findByUsername(loginRequest.getUsername());
        //We will check here for user
        if (user==null){
            return null;
        }
        //We will check here for the password
        if (user.getPassword().equals(loginRequest.getPassword())){
            return user;
        }
        return null;
    }
    public Long SaveUser(SignupRequest loginRequest) {
        Users user = new Users();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        return userRepository.save(user).getId();
    }
}



