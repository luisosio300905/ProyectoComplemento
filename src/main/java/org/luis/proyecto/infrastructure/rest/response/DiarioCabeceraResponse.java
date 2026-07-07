package org.luis.proyecto.infrastructure.rest.response;

import java.time.LocalDateTime;

public record DiarioCabeceraResponse(
        Long diaCabCompId,
        Integer diaCabAno,
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

