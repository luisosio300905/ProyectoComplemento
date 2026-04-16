package org.luis.proyecto.application.usecase.producto.impl;

import org.luis.proyecto.application.usecase.producto.ListaProductosUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;

import java.util.List;

public class ListaProductosUseCaseImpl implements ListaProductosUseCase {
    private ProductoRepository productoRepository;

    public ListaProductosUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
}
