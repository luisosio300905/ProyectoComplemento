package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DiarioCabeceraRequest(
        @NotNull(message = "El año no puede ser nulo")
        Integer diaCabAno,
        @NotNull(message = "El mes no puede ser nulo")
        Integer diaCabMes,
        String empresaId,
        LocalDateTime diaCabFec,
        String diaCabGlosa,
        String diaCabAccImp,
        String diaCabAccEdi,
        Integer subMovId,
        Integer movConId,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema
) {}

