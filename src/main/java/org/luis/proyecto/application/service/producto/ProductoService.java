package org.luis.proyecto.application.service.producto;

import org.luis.proyecto.domain.model.Producto;

public interface ProductoService {
    void crear(Producto producto);
    void actualizar(Integer id, Producto producto);
    void eliminar(Integer id);
}
