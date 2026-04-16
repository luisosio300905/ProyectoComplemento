package org.luis.proyecto.application.service.producto.impl;

import org.luis.proyecto.application.port.in.producto.ActualizarProductoPort;
import org.luis.proyecto.application.port.in.producto.CrearProductoPort;
import org.luis.proyecto.application.port.in.producto.EliminarProductoPort;
import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.domain.model.Producto;

public class ProductoServiceImpl implements ProductoService {
    private final CrearProductoPort crearProductoPort;
    private final ActualizarProductoPort actualizarProductoPort;
    private final EliminarProductoPort eliminarProductoPort;

    public ProductoServiceImpl(CrearProductoPort crearProductoPort, ActualizarProductoPort actualizarProductoPort, EliminarProductoPort eliminarProductoPort) {
        this.crearProductoPort = crearProductoPort;
        this.actualizarProductoPort = actualizarProductoPort;
        this.eliminarProductoPort = eliminarProductoPort;
    }

    public void crear(Producto producto) {
        crearProductoPort.crear(producto);
    }

    public void actualizar(Integer id, Producto producto) {
        actualizarProductoPort.actualizar(id, producto);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarProductoPort.eliminar(id);
    }
}
