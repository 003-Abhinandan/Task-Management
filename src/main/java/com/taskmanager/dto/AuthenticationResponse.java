package com.taskmanager.dto;

import com.taskmanager.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
     private String jwt;
     private Long userId;
     private UserRole userRole;

}
