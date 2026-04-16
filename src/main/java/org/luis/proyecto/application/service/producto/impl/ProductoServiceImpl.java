package org.luis.proyecto.application.service.producto.impl;

import org.luis.proyecto.application.usecase.producto.ActualizarProductoUseCase;
import org.luis.proyecto.application.usecase.producto.CrearProductoUseCase;
import org.luis.proyecto.application.usecase.producto.EliminarProductoUseCase;
import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.application.usecase.producto.ListaProductosUseCase;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    private final CrearProductoUseCase crearProductoUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ListaProductosUseCase listaProductosUseCase;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(CrearProductoUseCase crearProductoUseCase, ActualizarProductoUseCase actualizarProductoUseCase, EliminarProductoUseCase eliminarProductoUseCase, ListaProductosUseCase listaProductosUseCase, ProductoMapper productoMapper) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.listaProductosUseCase = listaProductosUseCase;
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

    @Override
    public void eliminar(Integer id) {
        eliminarProductoUseCase.eliminar(id);
    }

    @Override
    public List<ProductoResponse> obtenerTodos() {
        return productoMapper.toProductoResponseList(listaProductosUseCase.obtenerTodos());
    }
}
