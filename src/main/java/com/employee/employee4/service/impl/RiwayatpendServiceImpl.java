package com.employee.employee4.service.impl;

import com.employee.employee4.dto.RiwayatpendDto;
import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Riwayatpend;
import com.employee.employee4.mapper.RiwayatpendMapper;
import com.employee.employee4.repository.RiwayatpendRepository;
import com.employee.employee4.service.RiwayatpendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RiwayatpendServiceImpl implements RiwayatpendService {
/*

    private RiwayatpendRepository riwayatpendRepository;

    @Autowired
    public RiwayatpendServiceImpl(RiwayatpendRepository riwayatpendRepository) {
        this.riwayatpendRepository = riwayatpendRepository;
    }

    @Override
    public List<RiwayatpendDto> getAllRiwayatpends() {
        List<Riwayatpend> riwayatpends = riwayatpendRepository.findAll();
        List<RiwayatpendDto> riwayatpendDtos = riwayatpends.stream()
                .map((riwayatpend) -> RiwayatpendMapper.mapToRiwayatpendDto(riwayatpend))
                .collect(Collectors.toList());
        return riwayatpendDtos;
    }

    @Override
    public void createRiwayatpend(RiwayatpendDto riwayatpendDto) {
        Riwayatpend riwayatpend = RiwayatpendMapper.mapToRiwayatpend(riwayatpendDto);
        riwayatpendRepository.save(riwayatpend);
    }

    @Override
    public RiwayatpendDto getRiwayatpendById(Long riwayatpendId) {
        Riwayatpend riwayatpend = riwayatpendRepository.findById(riwayatpendId).get();
        RiwayatpendDto riwayatpendDto = RiwayatpendMapper.mapToRiwayatpendDto(riwayatpend);
        return riwayatpendDto;
    }

    @Override
    public void updateRiwayatpend(RiwayatpendDto riwayatpendDto) {
        riwayatpendRepository.save(RiwayatpendMapper.mapToRiwayatpend(riwayatpendDto));
    }

    @Override
    public void deleteRiwayatpend(Long riwayatpendId) {
        riwayatpendRepository.deleteById(riwayatpendId);
    }

 */
@Autowired
private RiwayatpendRepository riwayatpendRepository;

    @Override
    public List<Riwayatpend> getAllRiwayatpends() {
        return riwayatpendRepository.findAll();
    }

    @Override
    public void saveRiwayatpend(Riwayatpend riwayatpend) {
        this.riwayatpendRepository.save(riwayatpend);
    }

    @Override
    public Riwayatpend getRiwayatpendById(long id) {
        Optional<Riwayatpend> optional = riwayatpendRepository.findById(id);
        Riwayatpend riwayatpend;
        if (optional.isPresent()) {
            riwayatpend = optional.get();
        } else {
            throw new RuntimeException(" Riwayatpend not found for id :: " + id);
        }
        return riwayatpend;
    }

    @Override
    public void deleteRiwayatpendById(long id) {
        this.riwayatpendRepository.deleteById(id);
    }

    @Override
    public Optional<Riwayatpend> getGelarById(long id) {return riwayatpendRepository.findById(id);}
}