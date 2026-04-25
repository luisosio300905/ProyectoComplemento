package org.luis.proyecto.application.service.producto;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;

import java.util.List;

public interface ProductoService {
    Producto crear(ProductoRequest producto);
    Producto actualizar(Integer id, ProductoRequest producto);
    Producto actualizar(String codigo, ProductoRequest producto);
    void eliminar(Integer id);
    Producto obtenerProducto(Integer id);
    List<Producto> obtenerTodos();
}
