package com.employee.employee4.service;

import com.employee.employee4.dto.DepartementDto;

import java.util.List;

public interface DepartementService {
    List<DepartementDto> getAllDepartements();
    void createDepartement(DepartementDto departement);

    DepartementDto getDepartementById(Long departementId);

    void updateDepartement(DepartementDto departementDto);

    void deleteDepartement(Long departementId);

}
