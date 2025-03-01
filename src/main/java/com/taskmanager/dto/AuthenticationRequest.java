package com.taskmanager.dto;
import lombok.Data;
import lombok.Getter;

@Data
public class AuthenticationRequest {

     private String email;
     private String password;

}
