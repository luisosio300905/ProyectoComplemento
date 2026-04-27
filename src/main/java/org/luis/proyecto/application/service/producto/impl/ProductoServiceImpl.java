package org.luis.proyecto.application.service.producto.impl;

import org.luis.proyecto.application.usecase.producto.*;
import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.domain.model.Producto;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    private final CrearProductoUseCase crearProductoUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ListaProductosUseCase listaProductosUseCase;
    private final ObtenerProductoUseCase obtenerProductoUseCase;

    public ProductoServiceImpl(CrearProductoUseCase crearProductoUseCase, ActualizarProductoUseCase actualizarProductoUseCase, EliminarProductoUseCase eliminarProductoUseCase, ListaProductosUseCase listaProductosUseCase, ObtenerProductoUseCase obtenerProductoUseCase) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.listaProductosUseCase = listaProductosUseCase;
        this.obtenerProductoUseCase = obtenerProductoUseCase;
    }

    @Override
    public Producto crear(Producto producto) {
        return crearProductoUseCase.crear(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        return actualizarProductoUseCase.actualizar(id, producto);
    }

    @Override
    public Producto actualizar(String codigo, Producto producto) {
        return actualizarProductoUseCase.actualizar(codigo, producto);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarProductoUseCase.eliminar(id);
    }

    @Override
    public Producto obtenerProducto(Integer id) {
        return obtenerProductoUseCase.obtenerProducto(id);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return listaProductosUseCase.obtenerTodos();
    }
}
