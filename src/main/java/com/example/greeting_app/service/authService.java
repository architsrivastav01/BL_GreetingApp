package com.example.greeting_app.service;

import com.example.greeting_app.dto.authUserDTO;
import com.example.greeting_app.dto.loginDTO;
import com.example.greeting_app.interfaces.IAuthService;
import com.example.greeting_app.model.User;
import com.example.greeting_app.repository.userRepository;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class authService implements IAuthService {

    @Autowired
    userRepository userRepo;

    @Override
    public User register(authUserDTO userDTO) throws Exception {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());

        return userRepo.save(user);
    }

    @Override
    public String login(@Valid loginDTO logdto) {
        Optional<User> user= Optional.ofNullable(userRepo.findByEmail(logdto.getEmail()));
        return "Congratulations!! You have logged in successfully!";
    }
}