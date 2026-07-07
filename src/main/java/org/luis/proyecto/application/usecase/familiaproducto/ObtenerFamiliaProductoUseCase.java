package org.luis.proyecto.application.usecase.familiaproducto;

import org.luis.proyecto.domain.model.FamiliaProducto;
import java.util.Optional;

public interface ObtenerFamiliaProductoUseCase {
    Optional<FamiliaProducto> obtenerPorId(Integer id);
}
