package org.luis.proyecto.application.usecase.comprobantepago;

import org.luis.proyecto.domain.model.ComprobantePago;

public interface ObtenerComprobantePagoUseCase {
    ComprobantePago obtenerComprobantePago(Integer id);
}
