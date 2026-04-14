package org.luis.proyecto.producto.domain.repository;

import org.luis.proyecto.producto.domain.model.Producto;

import java.util.Optional;

public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    void deleteById(Integer id);
}

