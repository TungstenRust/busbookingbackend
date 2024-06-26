package com.example.busbookingbackend.controllers;

import com.example.busbookingbackend.dto.LoginRequest;
import com.example.busbookingbackend.dto.RoleRequest;
import com.example.busbookingbackend.dto.SignupRequest;
import com.example.busbookingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Map<String, Object> validateCredentials(@RequestBody LoginRequest loginRequest) {
        var data = new HashMap<String, Object>();
        data.put("status", "Success");
        return data;
    }
    @PostMapping("/signup")
    public Long addNewCredentials(@RequestBody SignupRequest signupRequest) {
        return userService.SaveUser(signupRequest);
    }
    @PostMapping("/role")
    public Long createRole(@RequestBody RoleRequest roleRequest) {
        return userService.SaveRole(roleRequest).getId();
    }
}
