package org.luis.proyecto.application.usecase.detalleventa.impl;

import org.luis.proyecto.application.usecase.detalleventa.ListaDetalleVentaUseCase;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

import java.util.List;

public class ListaDetalleVentaUseCaseImpl implements ListaDetalleVentaUseCase {
    private DetalleVentaRepository detalleVentaRepository;

    public ListaDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> obtenerTodos(){
        return detalleVentaRepository.findAll();
    }

}
