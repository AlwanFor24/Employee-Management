package com.employee.employee4.dto;

import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Riwayatpend;
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

public class EmployeeDto {

    private Long id;
    private int nip;
    private byte[] foto;
    private String nama;
    private String departement;
    private String riwayatpend;
    private String email;
    private int notelp;
    private float salary;
    private Date createdAt;
    private Date updatedAt;


    //Konstruktor buat mapper
    public EmployeeDto(Long id,
                       int nip,
                       String nama,
                       byte[] foto,
                       String namadepart,
                       String riwayat,
                       String email,
                       float salary,
                       Date createdAt,
                       Date updatedAt
                       ) {

    }
}
