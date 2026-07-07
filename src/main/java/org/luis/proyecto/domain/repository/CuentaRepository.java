package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository {
    Cuenta save(Cuenta cuenta);
    Optional<Cuenta> findById(String id);
    void deleteById(String id);
    List<Cuenta> findAll();
    boolean existsById(String id);
}

