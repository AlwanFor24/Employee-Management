package com.employee.employee4.service.impl;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.payload.LoginRestDto;
import com.employee.employee4.service.AuthRestService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.swing.*;


@Service
public class AuthRestServiceImpl implements AuthRestService {

    private AuthenticationManager authenticationManager;

    public AuthRestServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String loginrest(UserDto userDto){

        JPasswordField loginRestDto;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
               userDto.getEmail(),
               userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return  "User Logged-in succesfully";
    }

}
