package org.luis.proyecto.infrastructure.rest.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record VentaRequest(
    @NotNull(message = "La fecha no puede ser nula")
    LocalDateTime fecha,

    @NotNull(message = "El total no puede ser nulo")
    BigDecimal total,

    @NotNull(message = "Debe ingresar el ID del comprobante de pago")
    Integer idComprobantePago
) {
    
}
