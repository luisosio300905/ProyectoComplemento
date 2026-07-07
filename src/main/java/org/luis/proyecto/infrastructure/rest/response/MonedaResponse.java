package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record MonedaResponse(
        Integer id,
        String monedaDescripcion,
        String monedaAbrev,
        Boolean monedaEst,
        String monedaAbrevSunat,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
