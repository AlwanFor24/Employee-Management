package com.employee.employee4.mapper;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getCreatedAt(),
                userDto.getUpdatedAt()

        );
        return user;
    }
}
