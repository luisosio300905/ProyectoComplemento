package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.DiarioDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDiarioDetalleRepository extends JpaRepository<DiarioDetalleEntity, Integer> {
    List<DiarioDetalleEntity> findByDiaCabCompId(Long diaCabCompId);
    void deleteByDiaCabCompId(Long diaCabCompId);
}

