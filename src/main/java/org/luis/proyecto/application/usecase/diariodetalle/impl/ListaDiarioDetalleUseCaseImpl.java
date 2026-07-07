package org.luis.proyecto.application.usecase.diariodetalle.impl;

import org.luis.proyecto.application.usecase.diariodetalle.ListaDiarioDetalleUseCase;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;

import java.util.List;

public class ListaDiarioDetalleUseCaseImpl implements ListaDiarioDetalleUseCase {
    private final DiarioDetalleRepository diarioDetalleRepository;

    public ListaDiarioDetalleUseCaseImpl(DiarioDetalleRepository diarioDetalleRepository) {
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public List<DiarioDetalle> obtenerTodos() {
        return diarioDetalleRepository.findAll();
    }

    @Override
    public List<DiarioDetalle> obtenerPorDiaCabCompId(Long diaCabCompId) {
        return diarioDetalleRepository.findByDiaCabCompId(diaCabCompId);
    }
}

