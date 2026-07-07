package org.luis.proyecto.application.service.diariocabecera;

import org.luis.proyecto.domain.model.DiarioCabecera;

import java.util.List;

public interface DiarioCabeceraService {
    DiarioCabecera crear(DiarioCabecera diarioCabecera);
    DiarioCabecera actualizar(Long id, DiarioCabecera diarioCabecera);
    void eliminar(Long id);
    DiarioCabecera obtenerById(Long id);
    DiarioCabecera obtenerByEmpresaId(String empresaId);
    List<DiarioCabecera> obtenerTodos();
    List<DiarioCabecera> obtenerPorAnoYMes(Integer ano, Integer mes);
}

