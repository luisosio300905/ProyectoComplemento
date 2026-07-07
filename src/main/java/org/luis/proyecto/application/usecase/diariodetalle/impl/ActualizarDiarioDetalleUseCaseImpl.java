package org.luis.proyecto.application.usecase.diariodetalle.impl;

import org.luis.proyecto.application.usecase.diariodetalle.ActualizarDiarioDetalleUseCase;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

public class ActualizarDiarioDetalleUseCaseImpl implements ActualizarDiarioDetalleUseCase {
    private final DiarioDetalleRepository diarioDetalleRepository;

    public ActualizarDiarioDetalleUseCaseImpl(DiarioDetalleRepository diarioDetalleRepository) {
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public DiarioDetalle actualizar(Integer id, DiarioDetalle diarioDetalle) {
        DiarioDetalle existente = diarioDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiarioDetalle no encontrado con ID: " + id));

        diarioDetalle.setDiaDetItem(existente.getDiaDetItem());
        return diarioDetalleRepository.save(diarioDetalle);
    }
}

