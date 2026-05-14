package org.luis.proyecto.application.usecase.compra;

import org.luis.proyecto.domain.model.Compra;

import java.util.List;

public interface ListaComprasUseCase {
    List<Compra> obtenerTodas();
}

