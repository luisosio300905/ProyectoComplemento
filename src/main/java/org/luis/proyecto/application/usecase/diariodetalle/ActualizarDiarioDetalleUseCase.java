package org.luis.proyecto.application.usecase.diariodetalle;

import org.luis.proyecto.domain.model.DiarioDetalle;

public interface ActualizarDiarioDetalleUseCase {
    DiarioDetalle actualizar(Integer id, DiarioDetalle diarioDetalle);
}

