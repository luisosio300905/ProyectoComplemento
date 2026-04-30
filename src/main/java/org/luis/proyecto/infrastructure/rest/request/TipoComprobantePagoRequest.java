package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoComprobantePagoRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar un tipo de comprobante")
        String tipoComprobante
) {}