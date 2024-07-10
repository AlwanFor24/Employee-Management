package com.employee.employee4.service.impl;

import com.employee.employee4.dto.DepartementDto;
import com.employee.employee4.entity.Departement;
import com.employee.employee4.mapper.DepartementMapper;
import com.employee.employee4.repository.DepartementRepository;
import com.employee.employee4.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartementServiceImpl implements DepartementService {
    /*

    private DepartementRepository departementRepository;

    @Autowired
    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public List<DepartementDto> getAllDepartements() {
        List<Departement> departements = departementRepository.findAll();
        List<DepartementDto> departementDtos = departements.stream()
                .map((departement) -> DepartementMapper.mapToDepartementDto(departement))
                .collect(Collectors.toList());
        return departementDtos;
    }

    @Override
    public List<DepartementDto> findAllDepartements() {
        return null;
    }

    @Override
    public void createDepartement(DepartementDto departementDto) {
        Departement departement = DepartementMapper.mapToDepartement(departementDto);
        departementRepository.save(departement);
    }

    @Override
    public DepartementDto getDepartementById(Long departementId) {
        Departement departement = departementRepository.findById(departementId).get();
        DepartementDto departementDto = DepartementMapper.mapToDepartementDto(departement);
        return departementDto;
    }

    @Override
    public void updateDepartement(DepartementDto departementDto) {
        departementRepository.save(DepartementMapper.mapToDepartement(departementDto));
    }

    @Override
    public void deleteDepartement(Long departementId) {
        departementRepository.deleteById(departementId);
    }

     */
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public void saveDepartement(Departement departement) {
        this.departementRepository.save(departement);
    }

    @Override
    public Departement getDepartementById(long id) {
        Optional<Departement> optional = departementRepository.findById(id);
        Departement departement;
        if (optional.isPresent()) {
            departement =  optional.get();
        } else {
            throw new RuntimeException(" Departement not found for id :: " + id);
        }
        return departement;
    }

    @Override
    public void deleteDepartementById(long id) {
        this.departementRepository.deleteById(id);
    }

    @Override
    public Optional<Departement> getDivisiById(long id) {return departementRepository.findById(id);}
}
