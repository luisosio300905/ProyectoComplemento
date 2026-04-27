package org.luis.proyecto.application.usecase.comprobantepago;

import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;

public interface ListaComprobantePagoUseCase {
    List<ComprobantePago> obtenerTodos();
}
