package org.luis.proyecto.application.usecase.venta.impl;

import java.util.List;

import org.luis.proyecto.application.usecase.venta.ListaVentaUseCase;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;

public class ListaVentaUseCaseImpl implements ListaVentaUseCase{
    private VentaRepository ventaRepository;

    public ListaVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> obtenerTodos() {
        return ventaRepository.findAll();
    }
}
