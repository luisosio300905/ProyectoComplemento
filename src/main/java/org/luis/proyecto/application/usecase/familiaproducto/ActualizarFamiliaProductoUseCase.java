package org.luis.proyecto.application.usecase.familiaproducto;

import org.luis.proyecto.domain.model.FamiliaProducto;

public interface ActualizarFamiliaProductoUseCase {
    FamiliaProducto actualizar(Integer id, FamiliaProducto familiaProducto);
}
