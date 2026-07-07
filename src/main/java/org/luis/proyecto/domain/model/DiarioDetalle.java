package org.luis.proyecto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DiarioDetalle {
    private Integer diaDetItem;
    private Long diaCabCompId;
    private String docId;
    private String procId;
    private String activId;
    private String tareaId;
    private String activoId;
    private String prodId;
    private String cenCostResp;
    private String gerenciaId;
    private String dptoId;
    private String seccId;
    private Long ctaCteId;
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String subDivId;
    private BigDecimal diaDetDebe;
    private BigDecimal diaDetHaber;
    private String diaDetNumDoc;
    private String diaDetTexOpe;
    private Long diaDetMovRefCabId;
    private Long diaDetMovRefDetId;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private Integer up;
    private String diaDetSerieDoc;
    private String monedaId;
    private LocalDateTime fecsistema2;
    private LocalDateTime fecsistema3;

    // Constructor vacío
    public DiarioDetalle() {}

    // Getters y Setters
    public Integer getDiaDetItem() { return diaDetItem; }
    public void setDiaDetItem(Integer diaDetItem) { this.diaDetItem = diaDetItem; }

    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }

    public String getDocId() { return docId; }
    public void setDocId(String docId) { this.docId = docId; }

    public String getProcId() { return procId; }
    public void setProcId(String procId) { this.procId = procId; }

    public String getActivId() { return activId; }
    public void setActivId(String activId) { this.activId = activId; }

    public String getTareaId() { return tareaId; }
    public void setTareaId(String tareaId) { this.tareaId = tareaId; }

    public String getActivoId() { return activoId; }
    public void setActivoId(String activoId) { this.activoId = activoId; }

    public String getProdId() { return prodId; }
    public void setProdId(String prodId) { this.prodId = prodId; }

    public String getCenCostResp() { return cenCostResp; }
    public void setCenCostResp(String cenCostResp) { this.cenCostResp = cenCostResp; }

    public String getGerenciaId() { return gerenciaId; }
    public void setGerenciaId(String gerenciaId) { this.gerenciaId = gerenciaId; }

    public String getDptoId() { return dptoId; }
    public void setDptoId(String dptoId) { this.dptoId = dptoId; }

    public String getSeccId() { return seccId; }
    public void setSeccId(String seccId) { this.seccId = seccId; }

    public Long getCtaCteId() { return ctaCteId; }
    public void setCtaCteId(Long ctaCteId) { this.ctaCteId = ctaCteId; }

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getSubDivId() { return subDivId; }
    public void setSubDivId(String subDivId) { this.subDivId = subDivId; }

    public BigDecimal getDiaDetDebe() { return diaDetDebe; }
    public void setDiaDetDebe(BigDecimal diaDetDebe) { this.diaDetDebe = diaDetDebe; }

    public BigDecimal getDiaDetHaber() { return diaDetHaber; }
    public void setDiaDetHaber(BigDecimal diaDetHaber) { this.diaDetHaber = diaDetHaber; }

    public String getDiaDetNumDoc() { return diaDetNumDoc; }
    public void setDiaDetNumDoc(String diaDetNumDoc) { this.diaDetNumDoc = diaDetNumDoc; }

    public String getDiaDetTexOpe() { return diaDetTexOpe; }
    public void setDiaDetTexOpe(String diaDetTexOpe) { this.diaDetTexOpe = diaDetTexOpe; }

    public Long getDiaDetMovRefCabId() { return diaDetMovRefCabId; }
    public void setDiaDetMovRefCabId(Long diaDetMovRefCabId) { this.diaDetMovRefCabId = diaDetMovRefCabId; }

    public Long getDiaDetMovRefDetId() { return diaDetMovRefDetId; }
    public void setDiaDetMovRefDetId(Long diaDetMovRefDetId) { this.diaDetMovRefDetId = diaDetMovRefDetId; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public Integer getUp() { return up; }
    public void setUp(Integer up) { this.up = up; }

    public String getDiaDetSerieDoc() { return diaDetSerieDoc; }
    public void setDiaDetSerieDoc(String diaDetSerieDoc) { this.diaDetSerieDoc = diaDetSerieDoc; }

    public String getMonedaId() { return monedaId; }
    public void setMonedaId(String monedaId) { this.monedaId = monedaId; }

    public LocalDateTime getFecsistema2() { return fecsistema2; }
    public void setFecsistema2(LocalDateTime fecsistema2) { this.fecsistema2 = fecsistema2; }

    public LocalDateTime getFecsistema3() { return fecsistema3; }
    public void setFecsistema3(LocalDateTime fecsistema3) { this.fecsistema3 = fecsistema3; }
}

