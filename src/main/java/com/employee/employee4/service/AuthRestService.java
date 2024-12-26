package com.employee.employee4.service;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.payload.LoginRestDto;
import org.springframework.stereotype.Service;



public interface AuthRestService {
    String loginrest(UserDto userDto);
}
