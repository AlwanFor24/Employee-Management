package com.employee.employee4.service;

import com.employee.employee4.dto.DepartementDto;
import com.employee.employee4.entity.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    /*
    List<DepartementDto> getAllDepartements();

    List<DepartementDto> findAllDepartements();
    void createDepartement(DepartementDto departement);

    DepartementDto getDepartementById(Long departementId);

    void updateDepartement(DepartementDto departementDto);

    void deleteDepartement(Long departementId);

     */

        List<Departement> getAllDepartements();
        void saveDepartement(Departement departement);
        Departement getDepartementById(long id);
        void deleteDepartementById(long id);

        Optional<Departement> getDivisiById(long id);
}
