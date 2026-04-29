package org.luis.proyecto.application.usecase.venta.impl;

import org.luis.proyecto.application.usecase.venta.CrearVentaUseCase;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;

public class CrearVentaUseCaseImpl implements CrearVentaUseCase{
    private final VentaRepository ventaRepository;

    public CrearVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Venta crear(Venta venta) {
        return ventaRepository.save(venta);
    }
}
