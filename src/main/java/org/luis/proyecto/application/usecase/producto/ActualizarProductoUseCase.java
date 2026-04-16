package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.application.port.in.producto.ActualizarProductoPort;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class ActualizarProductoUseCase implements ActualizarProductoPort {
    private final ProductoRepository productoRepository;

    public ActualizarProductoUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void actualizar(Integer id, Producto producto) {
        Producto productoActualizar = productoRepository.findById(id).orElseThrow();
        productoActualizar.setCategoria(producto.getCategoria());
        productoActualizar.setCodigo(producto.getCodigo());
        productoActualizar.setDescripcion(producto.getDescripcion());
        productoActualizar.setNombre(producto.getNombre());
        productoActualizar.setPrecio(producto.getPrecio());
        productoActualizar.setStock(producto.getStock());
        productoRepository.save(productoActualizar);
    }
}
