package org.luis.proyecto.application.usecase.diariodetalle.impl;

import org.luis.proyecto.application.usecase.diariodetalle.EliminarDiarioDetalleUseCase;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

public class EliminarDiarioDetalleUseCaseImpl implements EliminarDiarioDetalleUseCase {
    private final DiarioDetalleRepository diarioDetalleRepository;

    public EliminarDiarioDetalleUseCaseImpl(DiarioDetalleRepository diarioDetalleRepository) {
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public void eliminar(Integer id) {
        if (!diarioDetalleRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("DiarioDetalle no encontrado con ID: " + id);
        }
        diarioDetalleRepository.deleteById(id);
    }

    @Override
    public void eliminarPorDiaCabCompId(Long diaCabCompId) {
        diarioDetalleRepository.deleteByDiaCabCompId(diaCabCompId);
    }
}

