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

public class ResignDto {
    private Long id;
    private Employee employee;
    private String alasan;
    private Date createdAt;
    private Date updatedAt;

    public ResignDto(Long id, String nama, String alasan, Date createdAt) {
    }
}
