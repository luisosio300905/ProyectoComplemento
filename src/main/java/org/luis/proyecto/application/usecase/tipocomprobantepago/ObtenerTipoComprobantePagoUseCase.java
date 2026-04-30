package org.luis.proyecto.application.usecase.tipocomprobantepago;

import org.luis.proyecto.domain.model.TipoComprobantePago;

public interface ObtenerTipoComprobantePagoUseCase {
    TipoComprobantePago obtener(Integer id);
}