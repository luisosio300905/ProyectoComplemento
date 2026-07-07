package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record ComprobantePagoResponse(
        String id,
        String comPagDescripcion,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
){ }
