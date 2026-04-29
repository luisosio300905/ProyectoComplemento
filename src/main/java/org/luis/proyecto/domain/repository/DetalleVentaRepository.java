package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface DetalleVentaRepository {
    DetalleVenta save(DetalleVenta detalleVenta);
    void deleteById(Integer id);
    Optional<DetalleVenta> findById(Integer id);
    List<DetalleVenta> findAll();
}
