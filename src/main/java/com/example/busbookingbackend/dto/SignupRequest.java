package com.example.busbookingbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignupRequest {
    private String username;
    private String password;
    private Long role;
    private String name;
    private String email;

}
