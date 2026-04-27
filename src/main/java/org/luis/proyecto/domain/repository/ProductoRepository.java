package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    Optional<Producto> findByCodigo(String codigo);
    void deleteById(Integer id);
    List<Producto> findAll();
}


