package com.employee.employee4.service;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;

import java.util.List;
public interface EmployeeService {
    /*
    List<EmployeeDto> getAllEmployees();
    void createEmployee(EmployeeDto employee);

    EmployeeDto getEmployeeById(Long employeeId);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

     */
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);


}
