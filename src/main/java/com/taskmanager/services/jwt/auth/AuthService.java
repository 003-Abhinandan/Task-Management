package com.taskmanager.services.jwt.auth;


import com.taskmanager.dto.SignupRequest;
import com.taskmanager.dto.UserDto;

public interface AuthService {

    UserDto signupUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);



}
