package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.DiarioDetalle;

import java.util.List;
import java.util.Optional;

public interface DiarioDetalleRepository {
    DiarioDetalle save(DiarioDetalle diarioDetalle);
    Optional<DiarioDetalle> findById(Integer id);
    void deleteById(Integer id);
    List<DiarioDetalle> findAll();
    List<DiarioDetalle> findByDiaCabCompId(Long diaCabCompId);
    void deleteByDiaCabCompId(Long diaCabCompId);
}

