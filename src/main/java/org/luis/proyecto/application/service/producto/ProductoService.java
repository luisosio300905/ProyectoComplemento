package org.luis.proyecto.application.service.producto;

import org.luis.proyecto.domain.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto crear(Producto producto);
    Producto actualizar(Integer id, Producto producto);
    Producto actualizar(String codigo, Producto producto);
    void eliminar(Integer id);
    Producto obtenerProducto(Integer id);
    List<Producto> obtenerTodos();
}
