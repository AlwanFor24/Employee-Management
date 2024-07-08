package com.employee.employee4.service;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    Optional<Employee> getProductById(long id);



}
