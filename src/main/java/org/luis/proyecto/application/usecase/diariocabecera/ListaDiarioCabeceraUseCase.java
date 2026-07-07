package org.luis.proyecto.application.usecase.diariocabecera;

import org.luis.proyecto.domain.model.DiarioCabecera;

import java.util.List;

public interface ListaDiarioCabeceraUseCase {
    List<DiarioCabecera> obtenerTodos();
    List<DiarioCabecera> obtenerPorAnoYMes(Integer ano, Integer mes);
}

