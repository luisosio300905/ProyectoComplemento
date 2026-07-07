package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.infrastructure.persistence.entity.DiarioDetalleEntity;
import org.luis.proyecto.infrastructure.rest.request.DiarioDetalleRequest;
import org.luis.proyecto.infrastructure.rest.response.DiarioDetalleResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiarioDetalleMapper {

    public DiarioDetalle toDiarioDetalle(DiarioDetalleEntity diarioDetalleEntity) {
        DiarioDetalle diarioDetalle = new DiarioDetalle();
        diarioDetalle.setDiaDetItem(diarioDetalleEntity.getDiaDetItem());
        diarioDetalle.setDiaCabCompId(diarioDetalleEntity.getDiaCabCompId());
        diarioDetalle.setDocId(diarioDetalleEntity.getDocId());
        diarioDetalle.setProcId(diarioDetalleEntity.getProcId());
        diarioDetalle.setActivId(diarioDetalleEntity.getActivId());
        diarioDetalle.setTareaId(diarioDetalleEntity.getTareaId());
        diarioDetalle.setActivoId(diarioDetalleEntity.getActivoId());
        diarioDetalle.setProdId(diarioDetalleEntity.getProdId());
        diarioDetalle.setCenCostResp(diarioDetalleEntity.getCenCostResp());
        diarioDetalle.setGerenciaId(diarioDetalleEntity.getGerenciaId());
        diarioDetalle.setDptoId(diarioDetalleEntity.getDptoId());
        diarioDetalle.setSeccId(diarioDetalleEntity.getSeccId());
        diarioDetalle.setCtaCteId(diarioDetalleEntity.getCtaCteId());
        diarioDetalle.setCuentaId(diarioDetalleEntity.getCuentaId());
        diarioDetalle.setSubCtaId(diarioDetalleEntity.getSubCtaId());
        diarioDetalle.setDivisioId(diarioDetalleEntity.getDivisioId());
        diarioDetalle.setSubDivId(diarioDetalleEntity.getSubDivId());
        diarioDetalle.setDiaDetDebe(diarioDetalleEntity.getDiaDetDebe());
        diarioDetalle.setDiaDetHaber(diarioDetalleEntity.getDiaDetHaber());
        diarioDetalle.setDiaDetNumDoc(diarioDetalleEntity.getDiaDetNumDoc());
        diarioDetalle.setDiaDetTexOpe(diarioDetalleEntity.getDiaDetTexOpe());
        diarioDetalle.setDiaDetMovRefCabId(diarioDetalleEntity.getDiaDetMovRefCabId());
        diarioDetalle.setDiaDetMovRefDetId(diarioDetalleEntity.getDiaDetMovRefDetId());
        diarioDetalle.setUsrSistema(diarioDetalleEntity.getUsrSistema());
        diarioDetalle.setFecSistema(diarioDetalleEntity.getFecSistema());
        diarioDetalle.setHrsSistema(diarioDetalleEntity.getHrsSistema());
        diarioDetalle.setUp(diarioDetalleEntity.getUp());
        diarioDetalle.setDiaDetSerieDoc(diarioDetalleEntity.getDiaDetSerieDoc());
        diarioDetalle.setMonedaId(diarioDetalleEntity.getMonedaId());
        diarioDetalle.setFecsistema2(diarioDetalleEntity.getFecsistema2());
        diarioDetalle.setFecsistema3(diarioDetalleEntity.getFecsistema3());
        return diarioDetalle;
    }

    public DiarioDetalleEntity toDiarioDetalleEntity(DiarioDetalle diarioDetalle) {
        DiarioDetalleEntity diarioDetalleEntity = new DiarioDetalleEntity();
        if (diarioDetalle.getDiaDetItem() != null) {
            diarioDetalleEntity.setDiaDetItem(diarioDetalle.getDiaDetItem());
        }
        diarioDetalleEntity.setDiaCabCompId(diarioDetalle.getDiaCabCompId());
        diarioDetalleEntity.setDocId(diarioDetalle.getDocId());
        diarioDetalleEntity.setProcId(diarioDetalle.getProcId());
        diarioDetalleEntity.setActivId(diarioDetalle.getActivId());
        diarioDetalleEntity.setTareaId(diarioDetalle.getTareaId());
        diarioDetalleEntity.setActivoId(diarioDetalle.getActivoId());
        diarioDetalleEntity.setProdId(diarioDetalle.getProdId());
        diarioDetalleEntity.setCenCostResp(diarioDetalle.getCenCostResp());
        diarioDetalleEntity.setGerenciaId(diarioDetalle.getGerenciaId());
        diarioDetalleEntity.setDptoId(diarioDetalle.getDptoId());
        diarioDetalleEntity.setSeccId(diarioDetalle.getSeccId());
        diarioDetalleEntity.setCtaCteId(diarioDetalle.getCtaCteId());
        diarioDetalleEntity.setCuentaId(diarioDetalle.getCuentaId());
        diarioDetalleEntity.setSubCtaId(diarioDetalle.getSubCtaId());
        diarioDetalleEntity.setDivisioId(diarioDetalle.getDivisioId());
        diarioDetalleEntity.setSubDivId(diarioDetalle.getSubDivId());
        diarioDetalleEntity.setDiaDetDebe(diarioDetalle.getDiaDetDebe());
        diarioDetalleEntity.setDiaDetHaber(diarioDetalle.getDiaDetHaber());
        diarioDetalleEntity.setDiaDetNumDoc(diarioDetalle.getDiaDetNumDoc());
        diarioDetalleEntity.setDiaDetTexOpe(diarioDetalle.getDiaDetTexOpe());
        diarioDetalleEntity.setDiaDetMovRefCabId(diarioDetalle.getDiaDetMovRefCabId());
        diarioDetalleEntity.setDiaDetMovRefDetId(diarioDetalle.getDiaDetMovRefDetId());
        diarioDetalleEntity.setUsrSistema(diarioDetalle.getUsrSistema());
        diarioDetalleEntity.setFecSistema(diarioDetalle.getFecSistema());
        diarioDetalleEntity.setHrsSistema(diarioDetalle.getHrsSistema());
        diarioDetalleEntity.setUp(diarioDetalle.getUp());
        diarioDetalleEntity.setDiaDetSerieDoc(diarioDetalle.getDiaDetSerieDoc());
        diarioDetalleEntity.setMonedaId(diarioDetalle.getMonedaId());
        diarioDetalleEntity.setFecsistema2(diarioDetalle.getFecsistema2());
        diarioDetalleEntity.setFecsistema3(diarioDetalle.getFecsistema3());
        return diarioDetalleEntity;
    }

    public DiarioDetalle toDiarioDetalle(DiarioDetalleRequest diarioDetalleRequest) {
        DiarioDetalle diarioDetalle = new DiarioDetalle();
        diarioDetalle.setDiaCabCompId(diarioDetalleRequest.diaCabCompId());
        diarioDetalle.setDocId(diarioDetalleRequest.docId());
        diarioDetalle.setProcId(diarioDetalleRequest.procId());
        diarioDetalle.setActivId(diarioDetalleRequest.activId());
        diarioDetalle.setTareaId(diarioDetalleRequest.tareaId());
        diarioDetalle.setActivoId(diarioDetalleRequest.activoId());
        diarioDetalle.setProdId(diarioDetalleRequest.prodId());
        diarioDetalle.setCenCostResp(diarioDetalleRequest.cenCostResp());
        diarioDetalle.setGerenciaId(diarioDetalleRequest.gerenciaId());
        diarioDetalle.setDptoId(diarioDetalleRequest.dptoId());
        diarioDetalle.setSeccId(diarioDetalleRequest.seccId());
        diarioDetalle.setCtaCteId(diarioDetalleRequest.ctaCteId());
        diarioDetalle.setCuentaId(diarioDetalleRequest.cuentaId());
        diarioDetalle.setSubCtaId(diarioDetalleRequest.subCtaId());
        diarioDetalle.setDivisioId(diarioDetalleRequest.divisioId());
        diarioDetalle.setSubDivId(diarioDetalleRequest.subDivId());
        diarioDetalle.setDiaDetDebe(diarioDetalleRequest.diaDetDebe());
        diarioDetalle.setDiaDetHaber(diarioDetalleRequest.diaDetHaber());
        diarioDetalle.setDiaDetNumDoc(diarioDetalleRequest.diaDetNumDoc());
        diarioDetalle.setDiaDetTexOpe(diarioDetalleRequest.diaDetTexOpe());
        diarioDetalle.setDiaDetMovRefCabId(diarioDetalleRequest.diaDetMovRefCabId());
        diarioDetalle.setDiaDetMovRefDetId(diarioDetalleRequest.diaDetMovRefDetId());
        diarioDetalle.setUsrSistema(diarioDetalleRequest.usrSistema());
        diarioDetalle.setFecSistema(diarioDetalleRequest.fecSistema());
        diarioDetalle.setHrsSistema(diarioDetalleRequest.hrsSistema());
        diarioDetalle.setUp(diarioDetalleRequest.up());
        diarioDetalle.setDiaDetSerieDoc(diarioDetalleRequest.diaDetSerieDoc());
        diarioDetalle.setMonedaId(diarioDetalleRequest.monedaId());
        diarioDetalle.setFecsistema2(diarioDetalleRequest.fecsistema2());
        diarioDetalle.setFecsistema3(diarioDetalleRequest.fecsistema3());
        return diarioDetalle;
    }

    public List<DiarioDetalle> toDiarioDetalleList(List<DiarioDetalleEntity> diarioDetalleEntities) {
        return diarioDetalleEntities
                .stream()
                .map(this::toDiarioDetalle)
                .toList();
    }

    public DiarioDetalleResponse toDiarioDetalleResponse(DiarioDetalle diarioDetalle) {
        return new DiarioDetalleResponse(
                diarioDetalle.getDiaDetItem(),
                diarioDetalle.getDiaCabCompId(),
                diarioDetalle.getDocId(),
                diarioDetalle.getProcId(),
                diarioDetalle.getActivId(),
                diarioDetalle.getTareaId(),
                diarioDetalle.getActivoId(),
                diarioDetalle.getProdId(),
                diarioDetalle.getCenCostResp(),
                diarioDetalle.getGerenciaId(),
                diarioDetalle.getDptoId(),
                diarioDetalle.getSeccId(),
                diarioDetalle.getCtaCteId(),
                diarioDetalle.getCuentaId(),
                diarioDetalle.getSubCtaId(),
                diarioDetalle.getDivisioId(),
                diarioDetalle.getSubDivId(),
                diarioDetalle.getDiaDetDebe(),
                diarioDetalle.getDiaDetHaber(),
                diarioDetalle.getDiaDetNumDoc(),
                diarioDetalle.getDiaDetTexOpe(),
                diarioDetalle.getDiaDetMovRefCabId(),
                diarioDetalle.getDiaDetMovRefDetId(),
                diarioDetalle.getUsrSistema(),
                diarioDetalle.getFecSistema(),
                diarioDetalle.getHrsSistema(),
                diarioDetalle.getUp(),
                diarioDetalle.getDiaDetSerieDoc(),
                diarioDetalle.getMonedaId(),
                diarioDetalle.getFecsistema2(),
                diarioDetalle.getFecsistema3()
        );
    }

    public List<DiarioDetalleResponse> toDiarioDetalleResponseList(List<DiarioDetalle> diarioDetalles) {
        return diarioDetalles
                .stream()
                .map(this::toDiarioDetalleResponse)
                .toList();
    }
}

