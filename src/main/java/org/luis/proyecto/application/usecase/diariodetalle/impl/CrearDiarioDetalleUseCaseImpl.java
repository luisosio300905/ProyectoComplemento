package org.luis.proyecto.application.usecase.diariodetalle.impl;

import org.luis.proyecto.application.usecase.diariodetalle.CrearDiarioDetalleUseCase;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;

public class CrearDiarioDetalleUseCaseImpl implements CrearDiarioDetalleUseCase {
    private final DiarioDetalleRepository diarioDetalleRepository;

    public CrearDiarioDetalleUseCaseImpl(DiarioDetalleRepository diarioDetalleRepository) {
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public DiarioDetalle crear(DiarioDetalle diarioDetalle) {
        return diarioDetalleRepository.save(diarioDetalle);
    }
}

