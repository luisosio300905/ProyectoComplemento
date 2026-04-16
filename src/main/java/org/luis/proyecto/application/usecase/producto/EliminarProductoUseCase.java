package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.application.port.in.producto.EliminarProductoPort;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class EliminarProductoUseCase implements EliminarProductoPort {
    private final ProductoRepository productoRepository;

    public EliminarProductoUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
