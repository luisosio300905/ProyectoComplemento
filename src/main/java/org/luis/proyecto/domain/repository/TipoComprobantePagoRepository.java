package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.TipoComprobantePago;
import java.util.List;
import java.util.Optional;

public interface TipoComprobantePagoRepository {
    TipoComprobantePago save(TipoComprobantePago tipoComprobantePago);
    Optional<TipoComprobantePago> findById(Integer id);
    void deleteById(Integer id);
    List<TipoComprobantePago> findAll();
}