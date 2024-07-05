package com.employee.employee4.service.impl;

import com.employee.employee4.dto.CutiDto;
import com.employee.employee4.entity.Cuti;
import com.employee.employee4.mapper.CutiMapper;
import com.employee.employee4.repository.EmployeeRepository;
import com.employee.employee4.repository.CutiRepository;
import com.employee.employee4.service.CutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CutiServiceImpl implements CutiService {

    private CutiRepository cutiRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CutiServiceImpl(CutiRepository cutiRepository, EmployeeRepository employeeRepository) {
        this.cutiRepository = cutiRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<CutiDto> getAllCutis() {
        List<Cuti> cutis = cutiRepository.findAll();
        List<CutiDto> cutiDtos = cutis.stream()
                .map((cuti) -> CutiMapper.mapToCutiDto(cuti))
                .collect(Collectors.toList());
        return cutiDtos;
    }

    @Override
    public void createCuti(CutiDto cutiDto) {
        Cuti cuti = CutiMapper.mapToCuti(cutiDto);
        cutiRepository.save(cuti);
    }

    @Override
    public CutiDto getCutiById(Long cutiId) {
        Cuti cuti = cutiRepository.findById(cutiId).get();
        CutiDto cutiDto = CutiMapper.mapToCutiDto(cuti);
        return cutiDto;
    }

    @Override
    public void updateCuti(CutiDto cutiDto) {
        cutiRepository.save(CutiMapper.mapToCuti(cutiDto));
    }

    @Override
    public void deleteCuti(Long cutiId) {
        cutiRepository.deleteById(cutiId);
    }

    @Override
    @Transactional
    public void CreateCuti(Long employeeId, Cuti cuti) {
        cutiRepository.save(cuti);
    }
}
