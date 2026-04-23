package org.luis.proyecto.application.usecase.producto.impl;

import org.luis.proyecto.application.usecase.producto.ActualizarProductoUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;

public class ActualizarProductoUseCaseImpl implements ActualizarProductoUseCase {
    private final ProductoRepository productoRepository;

    public ActualizarProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Producto productoActualizar = productoRepository.findById(id).orElseThrow();
        actualizarProducto(productoActualizar, producto);
        return productoRepository.save(productoActualizar);
    }

    @Override
    public Producto actualizar(String codigo, Producto producto) {
        Producto productoActualizar = productoRepository.findByCodigo(codigo).orElseThrow();
        actualizarProducto(productoActualizar, producto);
        return null;
    }

    private void actualizarProducto(Producto producto1, Producto producto2) {
        producto1.setCategoria(producto2.getCategoria());
        producto1.setCodigo(producto2.getCodigo());
        producto1.setDescripcion(producto2.getDescripcion());
        producto1.setNombre(producto2.getNombre());
        producto1.setPrecio(producto2.getPrecio());
        producto1.setStock(producto2.getStock());
    }
}
