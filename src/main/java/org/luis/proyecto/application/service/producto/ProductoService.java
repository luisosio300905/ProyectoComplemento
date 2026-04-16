package org.luis.proyecto.application.service.producto;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;

import java.util.List;

public interface ProductoService {
    ProductoResponse crear(ProductoRequest producto);
    ProductoResponse actualizar(Integer id, ProductoRequest producto);
    void eliminar(Integer id);
    List<ProductoResponse> obtenerTodos();
}
