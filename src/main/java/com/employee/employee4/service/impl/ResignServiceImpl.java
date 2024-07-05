package com.employee.employee4.service.impl;

import com.employee.employee4.dto.ResignDto;
import com.employee.employee4.entity.Resign;
import com.employee.employee4.mapper.ResignMapper;
import com.employee.employee4.repository.EmployeeRepository;
import com.employee.employee4.repository.ResignRepository;
import com.employee.employee4.service.ResignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResignServiceImpl implements ResignService {


    private ResignRepository resignRepository;


    private EmployeeRepository employeeRepository;

    @Autowired
    public ResignServiceImpl(ResignRepository resignRepository, EmployeeRepository employeeRepository) {
        this.resignRepository = resignRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<ResignDto> getAllResigns() {
        List<Resign> resigns = resignRepository.findAll();
        List<ResignDto> resignDtos = resigns.stream()
                .map((resign) -> ResignMapper.mapToResignDto(resign))
                .collect(Collectors.toList());
        return resignDtos;
    }

    @Override
    public void createResign(ResignDto resignDto) {
        Resign resign = ResignMapper.mapToResign(resignDto);
        resignRepository.save(resign);
    }

    @Override
    public ResignDto getResignById(Long resignId) {
        Resign resign = resignRepository.findById(resignId).get();
        ResignDto resignDto = ResignMapper.mapToResignDto(resign);
        return resignDto;
    }

    @Override
    public void updateResign(ResignDto resignDto) {
        resignRepository.save(ResignMapper.mapToResign(resignDto));
    }

    @Override
    public void deleteResign(Long resignId) {
        resignRepository.deleteById(resignId);
    }

    @Override
    @Transactional
    public void deleteEmployeeAndCreateResign(Long employeeId, Resign resign) {

        employeeRepository.deleteById(employeeId);
        resignRepository.save(resign);
    }
}