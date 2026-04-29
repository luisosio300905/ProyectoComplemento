package org.luis.proyecto.application.usecase.detalleventa.impl;

import org.luis.proyecto.application.usecase.detalleventa.EliminarDetalleVentaUseCase;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

public class EliminarDetalleVentaUseCaseImpl implements EliminarDetalleVentaUseCase {
    private final DetalleVentaRepository detalleVentaRepository;

    public EliminarDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public void eliminar(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
