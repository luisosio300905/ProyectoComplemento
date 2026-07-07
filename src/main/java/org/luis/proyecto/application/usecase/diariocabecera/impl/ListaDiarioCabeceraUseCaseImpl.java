package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.ListaDiarioCabeceraUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;

import java.util.List;

public class ListaDiarioCabeceraUseCaseImpl implements ListaDiarioCabeceraUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public ListaDiarioCabeceraUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public List<DiarioCabecera> obtenerTodos() {
        return diarioCabeceraRepository.findAll();
    }

    @Override
    public List<DiarioCabecera> obtenerPorAnoYMes(Integer ano, Integer mes) {
        return diarioCabeceraRepository.findByDiaCabAnoAndDiaCabMes(ano, mes);
    }
}

