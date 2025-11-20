package com.example.demo.repository;

import com.example.demo.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {
    boolean existsByUuid(String uuid); // NUEVO
    Transporte findByUuid(String uuid); // NUEVO
}
