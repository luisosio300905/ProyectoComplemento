package org.luis.proyecto.application.usecase.detalleventa;

import org.luis.proyecto.domain.model.DetalleVenta;

import java.util.List;

public interface ListaDetalleVentaUseCase {
    List<DetalleVenta> obtenerTodos();
}
