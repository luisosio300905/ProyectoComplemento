package org.luis.proyecto.application.usecase.compra;

import org.luis.proyecto.domain.model.Compra;

public interface ObtenerCompraUseCase {
    Compra obtenerCompra(Integer id);
}

