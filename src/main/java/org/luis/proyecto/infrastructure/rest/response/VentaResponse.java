package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaResponse(
    Integer id,
    LocalDateTime fecha,
    BigDecimal total
){}
