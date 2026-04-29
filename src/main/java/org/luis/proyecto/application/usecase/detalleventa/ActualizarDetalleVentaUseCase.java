package org.luis.proyecto.application.usecase.detalleventa;

import org.luis.proyecto.domain.model.DetalleVenta;

public interface ActualizarDetalleVentaUseCase {
    DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta);
}
