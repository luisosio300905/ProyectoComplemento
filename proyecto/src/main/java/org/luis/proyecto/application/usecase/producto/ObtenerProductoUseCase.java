package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.domain.model.Producto;

public interface ObtenerProductoUseCase {
    Producto obtenerProducto(Integer id);
}
