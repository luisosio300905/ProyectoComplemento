package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {
}