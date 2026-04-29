package org.luis.proyecto.application.usecase.detalleventa.impl;

import org.luis.proyecto.application.usecase.detalleventa.CrearDetalleVentaUseCase;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

public class CrearDetalleVentaUseCaseImpl implements CrearDetalleVentaUseCase {
    private final DetalleVentaRepository detalleVentaRepository;

    public CrearDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }


    @Override
    public DetalleVenta crear(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }
}
