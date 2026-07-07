package org.luis.proyecto.infrastructure.rest.request;

import java.time.LocalDateTime;

public record ComprobantePagoRequest(
    String id,
    String comPagDescripcion,
    String usrSistema,
    LocalDateTime fecSistema,
    String hrsSistema
) {}
