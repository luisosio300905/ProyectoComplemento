package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;

import java.util.List;
import java.util.Optional;

public interface SubCuentaRepository {
    SubCuenta save(SubCuenta subCuenta);
    Optional<SubCuenta> findById(SubCuentaPK id);
    void deleteById(SubCuentaPK id);
    List<SubCuenta> findAll();
    List<SubCuenta> findByCuentaId(String cuentaId);
    void deleteByCuentaId(String cuentaId);
}

