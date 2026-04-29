package org.luis.proyecto.application.usecase.venta;

import java.util.List;

import org.luis.proyecto.domain.model.Venta;

public interface ListaVentaUseCase {
    List<Venta> obtenerTodos();
}
