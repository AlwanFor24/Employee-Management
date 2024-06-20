package com.employee.employee4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private byte[] foto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Departement departement;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Riwayatpend riwayatpend;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private int notelp;

    @Column(nullable = false)
    private float salary;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;

    //Konstruktor buat mapper
    public Employee(Long id,
                    byte[] foto,
                    String nama,
                    String namadepart,
                    String riwayat,
                    int notelp, String email,
                    float salary) {
    }
}
