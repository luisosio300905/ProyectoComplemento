package org.luis.proyecto.application.usecase.familiaproducto;

import org.luis.proyecto.domain.model.FamiliaProducto;
import java.util.List;

public interface ListarFamiliasProductoUseCase {
    List<FamiliaProducto> listar();
}
