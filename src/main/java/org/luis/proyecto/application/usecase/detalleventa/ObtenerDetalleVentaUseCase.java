package org.luis.proyecto.application.usecase.detalleventa;

import org.luis.proyecto.domain.model.DetalleVenta;

public interface ObtenerDetalleVentaUseCase {
    DetalleVenta obtenerDetalleVenta(Integer id);
}
