package com.example.busbookingbackend.service;

import com.example.busbookingbackend.dto.LoginRequest;
import com.example.busbookingbackend.dto.RoleRequest;
import com.example.busbookingbackend.dto.SignupRequest;
import com.example.busbookingbackend.entity.Roles;
import com.example.busbookingbackend.entity.Users;
import com.example.busbookingbackend.repository.RoleRepository;
import com.example.busbookingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

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
    public Long SaveUser(SignupRequest signupRequest) {
        Users user = new Users();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setName(signupRequest.getName());
        //find the role by role id
        var role=roleRepository.findById(signupRequest.getRole());
        var roles=new HashSet<Roles>();
        roles.add(role.get());
        user.setRoles(roles);
        return userRepository.save(user).getId();
    }
    public Roles SaveRole(RoleRequest roleRequest){
        Roles role=new Roles();
        role.setName(roleRequest.getName());
        return roleRepository.save(role);
    }
}



