package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository {
    Proveedor save(Proveedor proveedor);
    Optional<Proveedor> findById(Integer id);
    void deleteById(Integer id);
    List<Proveedor> findAll();
}

