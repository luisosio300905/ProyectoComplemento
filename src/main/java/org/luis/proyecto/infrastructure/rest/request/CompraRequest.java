package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraRequest(
    @NotNull(message = "La fecha no puede ser nula")
    LocalDateTime fecha,

    @NotNull(message = "El total no puede ser nulo")
    BigDecimal total,

    @NotNull(message = "Debe ingresar el ID del proveedor")
    Integer idProveedor,

    @NotNull(message = "Debe ingresar el ID del comprobante de pago")
    String idComprobantePago
) {
}

