package org.luis.proyecto.application.usecase.diariodetalle;

import org.luis.proyecto.domain.model.DiarioDetalle;

public interface ObtenerDiarioDetalleUseCase {
    DiarioDetalle obtenerById(Integer id);
}

