package com.employee.employee4.service;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
