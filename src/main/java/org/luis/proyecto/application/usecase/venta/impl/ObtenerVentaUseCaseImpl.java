package org.luis.proyecto.application.usecase.venta.impl;

import org.luis.proyecto.application.usecase.venta.ObtenerVentaUseCase;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;

public class ObtenerVentaUseCaseImpl implements ObtenerVentaUseCase{
    private final VentaRepository ventaRepository;

    public ObtenerVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Venta obtenerVenta(Integer id) {
        return ventaRepository.findById(id).orElseThrow();
    }
}
