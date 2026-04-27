package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.model.TipoComprobantePago;

import java.math.BigDecimal;

public record ComprobantePagoRequest (
    @NotNull
    @NotBlank
    Cliente cliente,

    @NotNull
    @NotBlank
    BigDecimal total,

    @NotNull
    @NotBlank
    TipoComprobantePago tipoComprobantePago,

    @NotNull
    @NotBlank
    String descripcion
){}
