package org.luis.proyecto.application.usecase.detalleventa.impl;

import org.luis.proyecto.application.usecase.detalleventa.ActualizarDetalleVentaUseCase;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

public class ActualizarDetalleVentaUseCaseImpl implements ActualizarDetalleVentaUseCase {
    private final DetalleVentaRepository detalleVentaRepository;

    public ActualizarDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta detalleVentaActualizar = detalleVentaRepository.findById(id).orElseThrow();
        actualizarDetalleVenta(detalleVentaActualizar, detalleVenta);
        return detalleVentaActualizar;
    }

    private void actualizarDetalleVenta(DetalleVenta actualizar, DetalleVenta datos) {
        actualizar.setVenta(datos.getVenta());
        actualizar.setProducto(datos.getProducto());
        actualizar.setSubTotal(datos.getSubTotal());
    }
}
