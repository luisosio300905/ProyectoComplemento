package org.luis.proyecto.application.usecase.diariodetalle.impl;

import org.luis.proyecto.application.usecase.diariodetalle.ObtenerDiarioDetalleUseCase;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

public class ObtenerDiarioDetalleUseCaseImpl implements ObtenerDiarioDetalleUseCase {
    private final DiarioDetalleRepository diarioDetalleRepository;

    public ObtenerDiarioDetalleUseCaseImpl(DiarioDetalleRepository diarioDetalleRepository) {
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public DiarioDetalle obtenerById(Integer id) {
        return diarioDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiarioDetalle no encontrado con ID: " + id));
    }
}

