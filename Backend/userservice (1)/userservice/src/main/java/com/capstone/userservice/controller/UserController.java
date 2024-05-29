package com.capstone.userservice.controller;

import com.capstone.userservice.dto.UserLoginDTO;
import com.capstone.userservice.dto.UserRegistrationDTO;
import com.capstone.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        try {
            userService.registerUser(
                    userRegistrationDTO.getUsername(),
                    userRegistrationDTO.getEmail(),
                    userRegistrationDTO.getPassword(),
                    userRegistrationDTO.getConfirmPassword()
            );
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        try {
            userService.loginUser(
                    userLoginDTO.getUsername(),
                    userLoginDTO.getPassword()
            );
            return ResponseEntity.ok("Login successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
