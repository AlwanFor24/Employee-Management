package com.employee.employee4.repository;

import com.employee.employee4.entity.Riwayatpend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiwayatpendRepository extends JpaRepository<Riwayatpend, Long> {
}
