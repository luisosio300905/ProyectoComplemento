package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record CuentaResponse(
        String cuentaId,
        String cuentaDescripcion,
        Boolean cuentaEstado,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

