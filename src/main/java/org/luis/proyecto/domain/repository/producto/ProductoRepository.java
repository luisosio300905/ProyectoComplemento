package org.luis.proyecto.domain.repository.producto;

import org.luis.proyecto.domain.model.producto.Producto;

import java.util.Optional;

public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    void deleteById(Integer id);
}


