package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiarioDetalleResponse(
        Integer diaDetItem,
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

