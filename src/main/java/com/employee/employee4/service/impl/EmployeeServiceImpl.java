package com.employee.employee4.service.impl;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.entity.Resign;
import com.employee.employee4.mapper.EmployeeMapper;
import com.employee.employee4.repository.EmployeeRepository;
import com.employee.employee4.repository.ResignRepository;
import com.employee.employee4.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;


    private ResignRepository resignRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
