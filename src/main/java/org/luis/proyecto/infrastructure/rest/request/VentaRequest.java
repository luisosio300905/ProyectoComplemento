package org.luis.proyecto.infrastructure.rest.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VentaRequest(
    @Size(min = 0)
    int id,
    @NotNull
    LocalDateTime fecha,
    @Size(min = 0)
    BigDecimal total
) {
    
}
