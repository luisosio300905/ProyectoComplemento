package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "DiarioDetalle")
public class DiarioDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiaDetItem")
    private Integer diaDetItem;

    @Column(name = "DiaCabCompId")
    private Long diaCabCompId;

    @Column(name = "DocId")
    private String docId;

    @Column(name = "ProcId")
    private String procId;

    @Column(name = "ActivId")
    private String activId;

    @Column(name = "TareaId")
    private String tareaId;

    @Column(name = "ActivoId")
    private String activoId;

    @Column(name = "ProdId")
    private String prodId;

    @Column(name = "CenCostResp")
    private String cenCostResp;

    @Column(name = "GerenciaId")
    private String gerenciaId;

    @Column(name = "DptoId")
    private String dptoId;

    @Column(name = "SeccId")
    private String seccId;

    @Column(name = "CtaCteId")
    private Long ctaCteId;

    @Column(name = "CuentaId")
    private String cuentaId;

    @Column(name = "SubCtaId")
    private String subCtaId;

    @Column(name = "DivisioId")
    private String divisioId;

    @Column(name = "SubDivId")
    private String subDivId;

    @Column(name = "DiaDetDebe")
    private BigDecimal diaDetDebe;

    @Column(name = "DiaDetHaber")
    private BigDecimal diaDetHaber;

    @Column(name = "DiaDetNumDoc")
    private String diaDetNumDoc;

    @Column(name = "DiaDetTexOpe", columnDefinition = "TEXT")
    private String diaDetTexOpe;

    @Column(name = "DiaDetMovRefCabId")
    private Long diaDetMovRefCabId;

    @Column(name = "DiaDetMovRefDetId")
    private Long diaDetMovRefDetId;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @Column(name = "up")
    private Integer up;

    @Column(name = "DiaDetSerieDoc")
    private String diaDetSerieDoc;

    @Column(name = "MonedaId")
    private String monedaId;

    @Column(name = "fecsistema2")
    private LocalDateTime fecsistema2;

    @Column(name = "fecsistema3")
    private LocalDateTime fecsistema3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DiaCabCompId", insertable = false, updatable = false)
    private DiarioCabeceraEntity diarioCabecera;

    // Constructor vacío
    public DiarioDetalleEntity() {}

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

    public DiarioCabeceraEntity getDiarioCabecera() { return diarioCabecera; }
    public void setDiarioCabecera(DiarioCabeceraEntity diarioCabecera) { this.diarioCabecera = diarioCabecera; }
}

