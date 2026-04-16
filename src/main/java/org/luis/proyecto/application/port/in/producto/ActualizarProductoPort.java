package org.luis.proyecto.application.port.in.producto;

import org.luis.proyecto.domain.model.Producto;

public interface ActualizarProductoPort {
    void actualizar(Integer id, Producto producto);
}
