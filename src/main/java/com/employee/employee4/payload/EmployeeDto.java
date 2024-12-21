package com.employee.employee4.payload;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto {
    private long id;
    private int nama;
    private String departement;
    private String riwayatpend;
    private int notelp;
    private String email;
    private float gaji;



}
