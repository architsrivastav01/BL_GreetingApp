package com.example.greeting_app.controller;


import com.example.greeting_app.dto.authUserDTO;
import com.example.greeting_app.dto.responseDTO;
import com.example.greeting_app.model.User;
import com.example.greeting_app.service.authService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/auth")
public class authController {
    @Autowired
    authService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<responseDTO> register(@Valid @RequestBody authUserDTO userDTO) throws Exception{
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());

        User savedUser = authenticationService.register(user);
        responseDTO responseUserDTO = new responseDTO("User details submitted!", savedUser);

        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }
}