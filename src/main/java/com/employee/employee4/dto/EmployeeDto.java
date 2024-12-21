package com.employee.employee4.dto;

import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Riwayatpend;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Data

public class EmployeeDto {

    private Long id;
    private String nama;
    private int nip;
    private String departement;
    private String riwayatpend;
    private String email;
    private int notelp;
    private float gaji;


    //Konstruktor buat mapper
    public EmployeeDto(Long id,
                       String nama,
                       int nip,
                       String namadepart,
                       String riwayat,
                       String email,
                       int notelp,
                       float gaji
                       ) {

    }
}
