package org.luis.proyecto.application.usecase.venta;

import org.luis.proyecto.domain.model.Venta;

public interface ObtenerVentaUseCase {
    Venta obtenerVenta(Integer id);
}
