package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.model.ComprobantePago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraResponse(
    Integer id,
    LocalDateTime fecha,
    BigDecimal total,
    Proveedor proveedor,
    ComprobantePago comprobantePago
) {
}

