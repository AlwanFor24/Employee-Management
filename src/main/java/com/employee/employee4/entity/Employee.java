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
@Table(
        name = "employees",
        uniqueConstraints = {@UniqueConstraint(columnNames ={"nama"} )}

)
public class Employee {
    /*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int nip;

    @Column(nullable = false)
    private byte[] foto = new byte[0];

    @Column(nullable = false)
    private String departement;

    @Column(nullable = false)
    private String riwayatpend;

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
                    int nip,
                    byte[] foto,
                    String nama,
                    String namadepart,
                    String riwayat,
                    int notelp,
                    String email,
                    float salary,
                    Date createdAt,
                    Date updatedAt) {
    }

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int nip;
    @Column
    private String nama;

    @Column
    private String departement;

    @Column
    private String riwayatpend;

    @Column
    private int notelp;

    @Column
    private String email;

    @Column
    private float gaji;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getRiwayatpend() {
        return riwayatpend;
    }

    public void setRiwayatpend(String riwayatpend) {
        this.riwayatpend = riwayatpend;
    }

    public int getNotelp() {
        return notelp;
    }

    public void setNotelp(int notelp) {
        this.notelp = notelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGaji() {
        return gaji;
    }

    public void setGaji(float gaji) {
        this.gaji = gaji;
    }
}
