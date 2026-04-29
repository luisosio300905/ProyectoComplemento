package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoIdentidadRepository {
    TipoDocumentoIdentidad save(TipoDocumentoIdentidad tipodocumentoidentidad);
    Optional<TipoDocumentoIdentidad> findById(Integer id);
    Optional<TipoDocumentoIdentidad> findByNombre(String nombre);
    void deleteById(Integer id);
    List<TipoDocumentoIdentidad> findAll();
}
