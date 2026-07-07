package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaEntity;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDivisionariaRepository extends JpaRepository<DivisionariaEntity, DivisionariaPK> {
    List<DivisionariaEntity> findBySubCtaIdAndCuentaId(String subCtaId, String cuentaId);
    void deleteBySubCtaIdAndCuentaId(String subCtaId, String cuentaId);
}

