package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Venta;
import java.util.List;
import java.util.Optional;


public interface VentaRepository {
    Venta save(Venta venta);
    Optional<Venta> findById(Integer id);
    void deleteById(Integer id);
    List<Venta> findAll();
}
