package com.example.greeting_app.service;

import com.example.greeting_app.model.User;
import com.example.greeting_app.repository.userRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class authService  {

    @Autowired
    userRepository userRepo;
    public User register(User userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());

        return userRepo.save(user);
    }

}