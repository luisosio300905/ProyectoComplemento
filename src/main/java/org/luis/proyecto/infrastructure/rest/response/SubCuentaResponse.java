package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record SubCuentaResponse(
        String cuentaId,
        String subCtaId,
        String subCtaDescripcion,
        Boolean subCtaEstado,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

