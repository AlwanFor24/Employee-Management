package com.employee.employee4.service;

import com.employee.employee4.dto.CutiDto;
import com.employee.employee4.entity.Cuti;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CutiService {
    List<CutiDto> getAllCutis();
    void createCuti(CutiDto cuti);

    CutiDto getCutiById(Long cutiId);

    void updateCuti(CutiDto cutiDto);

    void deleteCuti(Long cutiId);

    @Transactional
    void CreateCuti(Long employeeId, Cuti cuti);
}