package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.persistence.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    void deleteById(Integer id);
    List<Producto> findAll();
}


