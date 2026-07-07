package org.luis.proyecto.infrastructure.rest.request;

import java.time.LocalDateTime;

public record MonedaRequest(
        String monedaDescripcion,
        String monedaAbrev,
        Boolean monedaEst,
        String monedaAbrevSunat,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
