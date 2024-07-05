package com.employee.employee4.dto;

import com.employee.employee4.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CutiDto {
    private Long id;
    private Employee employee;
    private String alasan;
    private Date createdAt;



    public CutiDto(Long id, String nama, Date createdAt, String Alasan) {
    }
}