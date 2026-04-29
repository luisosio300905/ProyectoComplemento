package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.model.TipoComprobantePago;

import java.math.BigDecimal;

public record ComprobantePagoResponse(
        Cliente cliente,
        BigDecimal total,
        TipoComprobantePago tipoComprobantePago,
        String descripcion
){ }
