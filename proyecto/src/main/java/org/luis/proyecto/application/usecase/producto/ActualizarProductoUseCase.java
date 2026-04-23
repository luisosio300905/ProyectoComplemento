package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.domain.model.Producto;

public interface ActualizarProductoUseCase {
    Producto actualizar(Integer id, Producto producto);
    Producto actualizar(String codigo, Producto producto);
}
