package org.luis.proyecto.application.usecase.proveedor;

import org.luis.proyecto.domain.model.Proveedor;

public interface ObtenerProveedorUseCase {
    Proveedor obtenerProveedor(Integer id);
}

