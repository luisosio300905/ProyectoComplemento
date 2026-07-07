package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.DiarioCabecera;

import java.util.List;
import java.util.Optional;

public interface DiarioCabeceraRepository {
    DiarioCabecera save(DiarioCabecera diarioCabecera);
    Optional<DiarioCabecera> findById(Long id);
    void deleteById(Long id);
    List<DiarioCabecera> findAll();
    List<DiarioCabecera> findByEmpresaId(String empresaId);
    List<DiarioCabecera> findByDiaCabAnoAndDiaCabMes(Integer ano, Integer mes);
}

