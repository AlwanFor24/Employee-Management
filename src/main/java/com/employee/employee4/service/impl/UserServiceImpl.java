package com.employee.employee4.service.impl;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.entity.User;
import com.employee.employee4.mapper.UserMapper;
import com.employee.employee4.repository.UserRepository;
import com.employee.employee4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream()
                .map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        UserDto userDto = UserMapper.mapToUserDto(user);
        return userDto;
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(UserMapper.mapToUser(userDto));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
