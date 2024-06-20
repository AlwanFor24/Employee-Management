package com.employee.employee4.service;

import com.employee.employee4.dto.EmployeeDto;

import java.util.List;
public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    void createEmployee(EmployeeDto employee);

    EmployeeDto getEmployeeById(Long employeeId);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

}
