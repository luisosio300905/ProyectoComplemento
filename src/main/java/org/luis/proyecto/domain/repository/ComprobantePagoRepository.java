package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;
import java.util.Optional;

public interface ComprobantePagoRepository {
    ComprobantePago save(ComprobantePago comprobantePago);
    void deleteById(Integer id);
    Optional<ComprobantePago> findById(Integer id);
    List<ComprobantePago> findAll();
}
