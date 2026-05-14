package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraRepository {
    Compra save(Compra compra);
    Optional<Compra> findById(Integer id);
    void deleteById(Integer id);
    List<Compra> findAll();
}

