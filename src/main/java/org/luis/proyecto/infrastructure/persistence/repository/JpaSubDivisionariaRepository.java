package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaEntity;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSubDivisionariaRepository extends JpaRepository<SubDivisionariaEntity, SubDivisionariaPK> {
    List<SubDivisionariaEntity> findByDivisioIdAndSubCtaIdAndCuentaId(String divisioId, String subCtaId, String cuentaId);
    void deleteByDivisioIdAndSubCtaIdAndCuentaId(String divisioId, String subCtaId, String cuentaId);
}

