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
        productoActualizar.setCategoria(producto.getCategoria());
        productoActualizar.setCodigo(producto.getCodigo());
        productoActualizar.setDescripcion(producto.getDescripcion());
        productoActualizar.setNombre(producto.getNombre());
        productoActualizar.setPrecio(producto.getPrecio());
        productoActualizar.setStock(producto.getStock());
        return productoRepository.save(productoActualizar);
    }
}
