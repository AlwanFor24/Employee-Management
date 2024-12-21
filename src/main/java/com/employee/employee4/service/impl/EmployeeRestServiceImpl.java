package com.employee.employee4.service.impl;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.exception.ResourceNotFoundException;
import com.employee.employee4.repository.EmployeeRepository;
import com.employee.employee4.service.EmployeeRestService;
import com.employee.employee4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeRestServiceImpl implements EmployeeRestService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRestServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createPost(EmployeeDto employeeDto) {

        //convert DTO to entity
        /*
        Employee employee = new Employee();
        employee.setNama(employeeDto.getNama());
        employee.setNip(employeeDto.getNip());
        employee.setDepartement(employeeDto.getDepartement());
        employee.setRiwayatpend(employeeDto.getRiwayatpend());
        employee.setEmail(employeeDto.getEmail());
        employee.setNotelp(employeeDto.getNotelp());
        employee.setGaji(employeeDto.getGaji());
         */

        Employee employee = mapToEntity(employeeDto);

        Employee newEmployee = employeeRepository.save(employee);


        //Convert entity to DTO
        EmployeeDto employeeResponse = mapToDTO(newEmployee);
        /*
        EmployeeDto employeeResponse = new EmployeeDto();
        employeeResponse.setId(newEmployee.getId());
        employeeResponse.setNama(newEmployee.getNama());
        employeeResponse.setNip(newEmployee.getNip());
        employeeResponse.setDepartement(newEmployee.getDepartement());
        employeeResponse.setRiwayatpend(newEmployee.getRiwayatpend());
        employeeResponse.setEmail(employeeResponse.getEmail());
        employeeResponse.setNotelp(employeeResponse.getNotelp());
        employeeResponse.setGaji(employeeResponse.getGaji());
         */


        return employeeResponse;
    }


    @Override
    public List<EmployeeDto> getAllPosts(){

        List<Employee> posts = employeeRepository.findAll();
        return posts.stream().map(employee-> mapToDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return mapToDTO(employee); // Assuming there's a method to map Employee to EmployeeDto
    }

    private EmployeeDto mapToDTO(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setNama(employee.getNama());
        employeeDto.setNip(employee.getNip());
        employeeDto.setDepartement(employee.getDepartement());
        employeeDto.setRiwayatpend(employee.getRiwayatpend());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setNotelp(employee.getNotelp());
        employeeDto.setGaji(employee.getGaji());

        return employeeDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setNama(employeeDto.getNama());
        employee.setNip(employeeDto.getNip());
        employee.setDepartement(employeeDto.getDepartement());
        employee.setRiwayatpend(employeeDto.getRiwayatpend());
        employee.setEmail(employeeDto.getEmail());
        employee.setNotelp(employeeDto.getNotelp());
        employee.setGaji(employeeDto.getGaji());

        return employee;
    }

}
