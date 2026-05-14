package org.luis.proyecto.application.usecase.compra;

import org.luis.proyecto.domain.model.Compra;

public interface ActualizarCompraUseCase {
    Compra actualizar(Integer id, Compra compra);
}

