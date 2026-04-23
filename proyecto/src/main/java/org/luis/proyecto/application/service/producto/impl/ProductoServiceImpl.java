package org.luis.proyecto.application.service.producto.impl;

import org.luis.proyecto.application.usecase.producto.*;
import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    private final CrearProductoUseCase crearProductoUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ListaProductosUseCase listaProductosUseCase;
    private final ObtenerProductoUseCase obtenerProductoUseCase;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(CrearProductoUseCase crearProductoUseCase, ActualizarProductoUseCase actualizarProductoUseCase, EliminarProductoUseCase eliminarProductoUseCase, ListaProductosUseCase listaProductosUseCase, ObtenerProductoUseCase obtenerProductoUseCase, ProductoMapper productoMapper) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.listaProductosUseCase = listaProductosUseCase;
        this.obtenerProductoUseCase = obtenerProductoUseCase;
        this.productoMapper = productoMapper;
    }

    public ProductoResponse crear(ProductoRequest producto) {
        return productoMapper.toProductoResponse(
                crearProductoUseCase.crear(productoMapper.toProducto(producto)));
    }

    public ProductoResponse actualizar(Integer id, ProductoRequest producto) {
        return productoMapper.toProductoResponse(
                actualizarProductoUseCase.actualizar(id, productoMapper.toProducto(producto)));
    }

    public ProductoResponse actualizar(String codigo, ProductoRequest producto) {
        return productoMapper.toProductoResponse(
                actualizarProductoUseCase.actualizar(codigo, productoMapper.toProducto(producto)));
    }

    @Override
    public void eliminar(Integer id) {
        eliminarProductoUseCase.eliminar(id);
    }

    @Override
    public ProductoResponse obtenerProducto(Integer id) {
        return productoMapper.toProductoResponse(obtenerProductoUseCase.obtenerProducto(id));
    }

    @Override
    public List<ProductoResponse> obtenerTodos() {
        return productoMapper.toProductoResponseList(listaProductosUseCase.obtenerTodos());
    }
}
