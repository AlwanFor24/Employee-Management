package com.employee.employee4.dto;

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

public class RiwayatpendDto {
    private Long id;
    private String riwayat;

    public RiwayatpendDto(Long id, String riwayat){

    }
}
