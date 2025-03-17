package com.example.greeting_app.interfaces;

import com.example.greeting_app.dto.AuthUserDTO;
import com.example.greeting_app.dto.LoginDTO;
import com.example.greeting_app.model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;

    String login(LoginDTO loginDTO);

    String forgotPassword(String email, String newPassword);

    String resetPassword(String email, String currentPassword, String newPassword);
}