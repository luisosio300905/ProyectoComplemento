package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record LaboratorioResponse(
        Integer id,
        String labDescripcion,
        Boolean labEstado,
        String codlab,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
