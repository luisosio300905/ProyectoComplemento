package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record SubDivisionariaResponse(
        String cuentaId,
        String subCtaId,
        String divisioId,
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

