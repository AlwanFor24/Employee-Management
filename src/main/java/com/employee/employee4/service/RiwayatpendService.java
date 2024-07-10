package com.employee.employee4.service;

import com.employee.employee4.dto.RiwayatpendDto;
import com.employee.employee4.entity.Riwayatpend;

import java.util.List;
import java.util.Optional;

public interface RiwayatpendService {

    /*
    List<RiwayatpendDto> getAllRiwayatpends();

    void createRiwayatpend(RiwayatpendDto riwayatpend);

    RiwayatpendDto getRiwayatpendById(Long riwayatpendId);

    void updateRiwayatpend(RiwayatpendDto riwayatpendDto);

    void deleteRiwayatpend(Long riwayatpendId);

     */
    List<Riwayatpend> getAllRiwayatpends();
    void saveRiwayatpend(Riwayatpend riwayatpend);
    Riwayatpend getRiwayatpendById(long id);
    void deleteRiwayatpendById(long id);

    Optional<Riwayatpend> getGelarById(long id);
}
