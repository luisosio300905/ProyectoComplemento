package org.luis.proyecto.application.usecase.comprobantepago;

import org.luis.proyecto.domain.model.ComprobantePago;

public interface ActualizarComprobantePagoUseCase {
    ComprobantePago actualizar(Integer id, ComprobantePago comprobantePago);
}
