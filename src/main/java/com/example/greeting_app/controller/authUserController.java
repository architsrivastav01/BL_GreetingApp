package com.example.greeting_app.controller;


import com.example.greeting_app.dto.AuthUserDTO;
import com.example.greeting_app.dto.LoginDTO;
import com.example.greeting_app.dto.ResponseDTO;
import com.example.greeting_app.model.AuthUser;
import com.example.greeting_app.service.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
//@RequestMapping("/auth")
public class authUserController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody AuthUserDTO userDTO) throws Exception{
        AuthUserDTO user = new AuthUserDTO();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());

        AuthUser savedUser = authenticationService.register(user);
        ResponseDTO responseUserDTO = new ResponseDTO("User details submitted!", savedUser);

        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO){
        String result=authenticationService.login(loginDTO);
        ResponseDTO responseUserDTO=new ResponseDTO("Login successfully!!",result);
        return  new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }

}