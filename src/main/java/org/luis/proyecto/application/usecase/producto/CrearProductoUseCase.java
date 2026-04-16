package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.application.port.in.producto.CrearProductoPort;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class CrearProductoUseCase implements CrearProductoPort {
    private final ProductoRepository productoRepository;

    public CrearProductoUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void crear(Producto producto) {
        productoRepository.save(producto);
    }
}
