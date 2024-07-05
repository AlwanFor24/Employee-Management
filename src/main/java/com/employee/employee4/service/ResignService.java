package com.employee.employee4.service;

import com.employee.employee4.dto.ResignDto;
import com.employee.employee4.entity.Resign;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ResignService {
    List<ResignDto> getAllResigns();
    void createResign(ResignDto resign);

    ResignDto getResignById(Long resignId);

    void updateResign(ResignDto resignDto);

    void deleteResign(Long resignId);

    @Transactional
    void deleteEmployeeAndCreateResign(Long employeeId, Resign resign);
}