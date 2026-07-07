package org.luis.proyecto.infrastructure.rest.request;

import java.time.LocalDateTime;

public record LaboratorioRequest(
        String labDescripcion,
        Boolean labEstado,
        String codlab,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
