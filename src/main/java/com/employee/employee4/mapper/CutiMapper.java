package com.employee.employee4.mapper;

import com.employee.employee4.dto.CutiDto;
import com.employee.employee4.entity.Cuti;
import com.employee.employee4.entity.Employee;

public class CutiMapper {
    public static CutiDto mapToCutiDto(Cuti cuti){
        CutiDto cutiDto = new CutiDto(
                cuti.getId(),
                cuti.getEmployee().getNama(),
                cuti.getCreatedAt(),
                cuti.getAlasan()
        );
        return cutiDto;
    }

    public static Cuti mapToCuti(CutiDto cutiDto){
        Cuti cuti = new Cuti(
                cutiDto.getId(),
                cutiDto.getEmployee().getNama(),
                cutiDto.getCreatedAt(),
                cutiDto.getAlasan()
        );
        return cuti;
    }
}