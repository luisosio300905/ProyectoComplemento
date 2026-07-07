package org.luis.proyecto.infrastructure.rest.request;

import java.time.LocalDateTime;

public record FamiliaProductoRequest(
        String famDescripcion,
        Boolean famEstado,
        String codfam,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
