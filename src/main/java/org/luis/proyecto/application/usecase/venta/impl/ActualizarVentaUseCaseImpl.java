package org.luis.proyecto.application.usecase.venta.impl;

import org.luis.proyecto.application.usecase.venta.ActualizarVentaUseCase;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;

public class ActualizarVentaUseCaseImpl implements ActualizarVentaUseCase{
    private final VentaRepository ventaRepository;

    public ActualizarVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Venta actualizar(Integer id, Venta venta) {
        Venta ventaActualizar = ventaRepository.findById(id).orElseThrow();
        actualizarVenta(ventaActualizar, venta);
        return ventaRepository.save(ventaActualizar);
    }

    private void actualizarVenta(Venta venta1, Venta venta2) {
        venta1.setFecha(venta2.getFecha());
        venta1.setTotal(venta2.getTotal());
    }

}
