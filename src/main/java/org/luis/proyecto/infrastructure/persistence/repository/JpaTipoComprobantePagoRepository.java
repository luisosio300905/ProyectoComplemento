package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.TipoComprobantePagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTipoComprobantePagoRepository extends JpaRepository<TipoComprobantePagoEntity, Integer> {
}