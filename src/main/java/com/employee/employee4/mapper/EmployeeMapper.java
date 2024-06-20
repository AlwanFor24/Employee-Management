package com.employee.employee4.mapper;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;
import lombok.AllArgsConstructor;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getNama(),
                employee.getFoto(),
                employee.getDepartement().getNamadepart(),
                employee.getRiwayatpend().getRiwayat(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFoto(),
                employeeDto.getNama(),
                employeeDto.getDepartement().getNamadepart(),
                employeeDto.getRiwayatpend().getRiwayat(),
                employeeDto.getNotelp(),
                employeeDto.getEmail(),
                employeeDto.getSalary()
        );
        return employee;
    }
}

