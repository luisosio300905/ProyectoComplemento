package org.luis.proyecto.application.usecase.diariodetalle;

import org.luis.proyecto.domain.model.DiarioDetalle;

import java.util.List;

public interface ListaDiarioDetalleUseCase {
    List<DiarioDetalle> obtenerTodos();
    List<DiarioDetalle> obtenerPorDiaCabCompId(Long diaCabCompId);
}

