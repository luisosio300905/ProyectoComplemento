package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.FamiliaProducto;
import java.util.List;
import java.util.Optional;

public interface FamiliaProductoRepository {
    FamiliaProducto save(FamiliaProducto familiaProducto);
    Optional<FamiliaProducto> findById(Integer id);
    void deleteById(Integer id);
    List<FamiliaProducto> findAll();
}
