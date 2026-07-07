package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoRepository {
    Documento save(Documento documento);
    void deleteById(String id);
    Optional<Documento> findById(String id);
    List<Documento> findAll();
}

