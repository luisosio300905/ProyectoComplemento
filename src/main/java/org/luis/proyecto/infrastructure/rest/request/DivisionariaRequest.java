package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record DivisionariaRequest(
        @NotBlank(message = "CuentaId no puede estar vacío")
        String cuentaId,
        @NotBlank(message = "SubCtaId no puede estar vacío")
        String subCtaId,
        @NotBlank(message = "DivisioId no puede estar vacío")
        String divisioId,
        String divisioDescripcion,
        Boolean divisioEstad,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

