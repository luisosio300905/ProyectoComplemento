package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Moneda;
import java.util.List;
import java.util.Optional;

public interface MonedaRepository {
    Moneda save(Moneda moneda);
    Optional<Moneda> findById(Integer id);
    void deleteById(Integer id);
    List<Moneda> findAll();
}
