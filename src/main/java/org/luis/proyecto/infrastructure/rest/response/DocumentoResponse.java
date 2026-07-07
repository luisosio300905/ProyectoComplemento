package org.luis.proyecto.infrastructure.rest.response;
import java.time.LocalDateTime;
public record DocumentoResponse(
    String id,
    String docDescripcion,
    String docDesCorta,
    String docAbrev,
    Boolean docEstado,
    String comPagId,
    Integer docNumDigSerie,
    Integer docNumDigNumero,
    Boolean docAfaNumerico,
    String usrSistema,
    LocalDateTime fecSistema,
    String hrsSistema
) {}
