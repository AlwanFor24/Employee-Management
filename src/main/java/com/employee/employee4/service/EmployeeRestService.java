package com.employee.employee4.service;

import com.employee.employee4.dto.EmployeeDto;

import java.util.List;

public interface EmployeeRestService {
    EmployeeDto createPost(EmployeeDto employeeDto);

    List<EmployeeDto> getAllPosts();

    EmployeeDto getEmployeeById(long id);

}
