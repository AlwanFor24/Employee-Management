package com.employee.employee4.mapper;

import com.employee.employee4.dto.DepartementDto;
import com.employee.employee4.entity.Departement;

public class DepartementMapper {
    public static DepartementDto mapToDepartementDto(Departement departement){
        DepartementDto departementDto = new DepartementDto(
                departement.getId(),
                departement.getNamadepart()

        );
        return departementDto;
    }

    public static Departement mapToDepartement(DepartementDto departementDto){
        Departement departement = new Departement(
                departementDto.getId(),
                departementDto.getNamadepart()

        );
        return departement;
    }
}
