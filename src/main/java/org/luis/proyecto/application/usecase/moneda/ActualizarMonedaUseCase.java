package org.luis.proyecto.application.usecase.moneda;

import org.luis.proyecto.domain.model.Moneda;

public interface ActualizarMonedaUseCase {
    Moneda actualizar(Integer id, Moneda moneda);
}
