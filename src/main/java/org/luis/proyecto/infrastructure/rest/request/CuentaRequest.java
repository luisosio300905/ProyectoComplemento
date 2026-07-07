package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record CuentaRequest(
        @NotBlank(message = "CuentaId no puede estar vacío")
        String cuentaId,
        String cuentaDescripcion,
        Boolean cuentaEstado,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

