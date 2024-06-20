package com.employee.employee4.service;

import com.employee.employee4.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    void createUser(UserDto user);

    UserDto getUserById(Long userId);

    void updateUser(UserDto userDto);

    void deleteUser(Long userId);
}
