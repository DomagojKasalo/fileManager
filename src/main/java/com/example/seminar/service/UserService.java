package com.example.seminar.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.seminar.model.DBFile;
import com.example.seminar.model.User;
import com.example.seminar.controller.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);
    
    User findByFirstName(String firstName);
    
}