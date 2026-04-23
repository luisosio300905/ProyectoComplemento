package org.luis.proyecto.application.usecase.producto.impl;

import org.luis.proyecto.application.usecase.producto.EliminarProductoUseCase;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase {
    private final ProductoRepository productoRepository;

    public EliminarProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
