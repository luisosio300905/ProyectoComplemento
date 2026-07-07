package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record FamiliaProductoResponse(
        Integer id,
        String famDescripcion,
        Boolean famEstado,
        String codfam,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}
