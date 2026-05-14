package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.luis.proyecto.domain.model.ComprobantePago;

public record VentaResponse(
    Integer id,
    LocalDateTime fecha,
    BigDecimal total,
    ComprobantePago comprobantePago
){}
