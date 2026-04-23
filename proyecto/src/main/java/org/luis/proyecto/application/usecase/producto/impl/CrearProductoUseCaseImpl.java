package org.luis.proyecto.application.usecase.producto.impl;

import org.luis.proyecto.application.usecase.producto.CrearProductoUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class CrearProductoUseCaseImpl implements CrearProductoUseCase {
    private final ProductoRepository productoRepository;

    public CrearProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }
}
