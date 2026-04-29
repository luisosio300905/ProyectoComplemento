package org.luis.proyecto.application.usecase.venta;

import org.luis.proyecto.domain.model.Venta;

public interface ActualizarVentaUseCase {
    Venta actualizar(Integer id, Venta venta);
}
