package org.luis.proyecto.application.usecase.venta.impl;

import org.luis.proyecto.application.usecase.venta.EliminarVentaUseCase;
import org.luis.proyecto.domain.repository.VentaRepository;

public class EliminarVentaUseCaseImpl implements EliminarVentaUseCase{
    private final VentaRepository ventaRepository;

    public EliminarVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }
}
