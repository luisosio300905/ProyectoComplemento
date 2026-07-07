package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record DivisionariaResponse(
        String cuentaId,
        String subCtaId,
        String divisioId,
        String divisioDescripcion,
        Boolean divisioEstad,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

