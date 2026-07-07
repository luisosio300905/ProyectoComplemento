package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;

import java.util.List;
import java.util.Optional;

public interface SubDivisionariaRepository {
    SubDivisionaria save(SubDivisionaria subDivisionaria);
    Optional<SubDivisionaria> findById(SubDivisionariaPK id);
    void deleteById(SubDivisionariaPK id);
    List<SubDivisionaria> findAll();
    List<SubDivisionaria> findByDivisionariaId(String cuentaId, String subCtaId, String divisioId);
    void deleteByDivisionariaId(String cuentaId, String subCtaId, String divisioId);
}

