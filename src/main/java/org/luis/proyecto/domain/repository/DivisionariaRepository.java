package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;

import java.util.List;
import java.util.Optional;

public interface DivisionariaRepository {
    Divisionaria save(Divisionaria divisionaria);
    Optional<Divisionaria> findById(DivisionariaPK id);
    void deleteById(DivisionariaPK id);
    List<Divisionaria> findAll();
    List<Divisionaria> findBySubCuentaId(String cuentaId, String subCtaId);
    void deleteBySubCuentaId(String cuentaId, String subCtaId);
}

