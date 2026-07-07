package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record SubDivisionariaRequest(
        @NotBlank(message = "CuentaId no puede estar vacío")
        String cuentaId,
        @NotBlank(message = "SubCtaId no puede estar vacío")
        String subCtaId,
        @NotBlank(message = "DivisioId no puede estar vacío")
        String divisioId,
        @NotBlank(message = "SubDivId no puede estar vacío")
        String subDivId,
        String subDivDescripcion,
        Boolean subDivCenCost,
        Boolean subDivCtaCte,
        Boolean subDivAnalisis,
        Boolean subDivEstado,
        Integer tipCtaId,
        Integer subDivNumDigSunat,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema,
        String cta5,
        String cta8
) {}

