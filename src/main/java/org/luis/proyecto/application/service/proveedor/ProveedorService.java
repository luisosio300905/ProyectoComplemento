package org.luis.proyecto.application.service.proveedor;

import org.luis.proyecto.domain.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    Proveedor crear(Proveedor proveedor);

    Proveedor actualizar(Integer id, Proveedor proveedor);

    void eliminar(Integer id);

    Proveedor obtenerProveedor(Integer id);

    List<Proveedor> obtenerTodos();
}

