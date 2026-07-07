package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;
import java.util.Optional;

public interface ComprobantePagoRepository {
    ComprobantePago save(ComprobantePago comprobantePago);
    void deleteById(String id);
    Optional<ComprobantePago> findById(String id);
    List<ComprobantePago> findAll();
}
