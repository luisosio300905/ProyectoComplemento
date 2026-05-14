package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ComprobantePagoRequest(
    @NotNull(message = "Debe ingresar el ID del cliente")
    Integer idCliente,

    @NotNull(message = "El total no puede ser nulo")
    BigDecimal total,

    @NotNull(message = "Debe ingresar el ID del tipo de comprobante")
    Integer idTipoComprobante,

    @NotNull(message = "La descripción no puede ser nula")
    String descripcion
) {}
