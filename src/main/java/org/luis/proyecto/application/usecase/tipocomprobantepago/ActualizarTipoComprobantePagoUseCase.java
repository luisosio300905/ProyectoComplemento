package org.luis.proyecto.application.usecase.tipocomprobantepago;

import org.luis.proyecto.domain.model.TipoComprobantePago;

public interface ActualizarTipoComprobantePagoUseCase {
    TipoComprobantePago actualizar(Integer id, TipoComprobantePago tipoComprobantePago);
}