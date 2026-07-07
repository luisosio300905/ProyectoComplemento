package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiarioDetalleRequest(
        @NotNull(message = "El ID de cabecera no puede ser nulo")
        Long diaCabCompId,
        String docId,
        String procId,
        String activId,
        String tareaId,
        String activoId,
        String prodId,
        String cenCostResp,
        String gerenciaId,
        String dptoId,
        String seccId,
        Long ctaCteId,
        String cuentaId,
        String subCtaId,
        String divisioId,
        String subDivId,
        BigDecimal diaDetDebe,
        BigDecimal diaDetHaber,
        String diaDetNumDoc,
        String diaDetTexOpe,
        Long diaDetMovRefCabId,
        Long diaDetMovRefDetId,
        String usrSistema,
        LocalDateTime fecSistema,
        String hrsSistema,
        Integer up,
        String diaDetSerieDoc,
        String monedaId,
        LocalDateTime fecsistema2,
        LocalDateTime fecsistema3
) {}

