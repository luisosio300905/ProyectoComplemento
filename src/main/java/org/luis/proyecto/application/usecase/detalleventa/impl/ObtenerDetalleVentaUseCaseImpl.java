package org.luis.proyecto.application.usecase.detalleventa.impl;

import org.luis.proyecto.application.usecase.detalleventa.ObtenerDetalleVentaUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

public class ObtenerDetalleVentaUseCaseImpl implements ObtenerDetalleVentaUseCase {
    private final DetalleVentaRepository detalleVentaRepository;

    public ObtenerDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(Integer id) {
        return detalleVentaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle Venta no encontrado"));
    }
}
