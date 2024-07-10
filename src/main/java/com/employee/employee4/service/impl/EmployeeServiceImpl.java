package com.employee.employee4.service.impl;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.entity.Riwayatpend;
import com.employee.employee4.mapper.EmployeeMapper;
import com.employee.employee4.repository.DepartementRepository;
import com.employee.employee4.repository.EmployeeRepository;
import com.employee.employee4.repository.RiwayatpendRepository;
import com.employee.employee4.service.EmployeeService;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

/*
    private EmployeeRepository employeeRepository;




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


 */
@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private DepartementRepository departementRepository;

@Autowired
private RiwayatpendRepository riwayatpendRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if (optional.isPresent()) {
            employee =  optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }


    @Override
    public Optional<Employee> getKaryawanById(long id) {
        return employeeRepository.findById(id);
    }




}
