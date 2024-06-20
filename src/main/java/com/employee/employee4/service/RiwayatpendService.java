package com.employee.employee4.service;

import com.employee.employee4.dto.RiwayatpendDto;

import java.util.List;

public interface RiwayatpendService {
    List<RiwayatpendDto> getAllRiwayatpends();
    void createRiwayatpend(RiwayatpendDto riwayatpend);

    RiwayatpendDto getRiwayatpendById(Long riwayatpendId);

    void updateRiwayatpend(RiwayatpendDto riwayatpendDto);

    void deleteRiwayatpend(Long riwayatpendId);
}
