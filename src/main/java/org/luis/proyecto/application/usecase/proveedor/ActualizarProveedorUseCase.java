package org.luis.proyecto.application.usecase.proveedor;

import org.luis.proyecto.domain.model.Proveedor;

public interface ActualizarProveedorUseCase {
    Proveedor actualizar(Integer id, Proveedor proveedor);
}

