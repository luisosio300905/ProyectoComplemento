package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record SubCuentaRequest(
        @NotBlank(message = "CuentaId no puede estar vacío")
        String cuentaId,
        @NotBlank(message = "SubCtaId no puede estar vacío")
        String subCtaId,
        String subCtaDescripcion,
        Boolean subCtaEstado,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

