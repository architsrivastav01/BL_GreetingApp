package com.example.greeting_app.interfaces;

import com.example.greeting_app.dto.authUserDTO;
import com.example.greeting_app.dto.loginDTO;
import com.example.greeting_app.model.User;

public interface IAuthService {
    User register(authUserDTO userDTO) throws Exception;

    String login(loginDTO loginDTO);
}