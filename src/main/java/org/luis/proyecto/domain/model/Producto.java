package org.luis.proyecto.domain.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public class Producto {
    private String grpAlmId;
    private String clsAlmId;
    private Integer iteAlmId;
    private String iteAlmCodBarra;
    private Integer labId;
    private Integer famId;
    private Integer comGenId;
    private String iteAlmDescDetalle;
    private String iteAlmDescResumen;
    private String iteAlmUso;
    private String iteAlmUniMed;
    private String iteAlmCtaCompra;
    private String iteAlmCtaEntMat;
    private String iteAlmCtaExist;
    private BigDecimal iteAlmPrecio;
    private Integer monedaId;
    private LocalDateTime iteAlmUltFecAdq;
    private Boolean iteAlmEstado;
    private LocalDateTime iteAlmFecBaja;
    private BigDecimal iteAlmStockMin;
    private BigDecimal iteAlmTasIGV;
    private BigDecimal iteAlmTasISC;
    private Boolean iteAlmControlado;
    private Integer iteAlmFraccUni;
    private BigDecimal iteAlmCosPro;
    private BigDecimal iteAlmDscto;
    private BigDecimal iteAlmDsctoAdi;
    private BigDecimal iteAlmUtilidadVta;
    private BigDecimal iteAlmUtilidadSug;
    private BigDecimal iteAlmPVPF;
    private BigDecimal iteAlmPreVta;
    private BigDecimal iteAlmValorVtaFar;
    private LocalDateTime iteAlmFecVen;
    private String codpro;
    private Boolean itemAlmCtrlAdm;
    private String unidMedId;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public Producto() {}
    public String getGrpAlmId() { return grpAlmId; }
    public void setGrpAlmId(String grpAlmId) { this.grpAlmId = grpAlmId; }
    public String getClsAlmId() { return clsAlmId; }
    public void setClsAlmId(String clsAlmId) { this.clsAlmId = clsAlmId; }
    public Integer getIteAlmId() { return iteAlmId; }
    public void setIteAlmId(Integer iteAlmId) { this.iteAlmId = iteAlmId; }
    public String getIteAlmCodBarra() { return iteAlmCodBarra; }
    public void setIteAlmCodBarra(String iteAlmCodBarra) { this.iteAlmCodBarra = iteAlmCodBarra; }
    public Integer getLabId() { return labId; }
    public void setLabId(Integer labId) { this.labId = labId; }
    public Integer getFamId() { return famId; }
    public void setFamId(Integer famId) { this.famId = famId; }
    public Integer getComGenId() { return comGenId; }
    public void setComGenId(Integer comGenId) { this.comGenId = comGenId; }
    public String getIteAlmDescDetalle() { return iteAlmDescDetalle; }
    public void setIteAlmDescDetalle(String iteAlmDescDetalle) { this.iteAlmDescDetalle = iteAlmDescDetalle; }
    public String getIteAlmDescResumen() { return iteAlmDescResumen; }
    public void setIteAlmDescResumen(String iteAlmDescResumen) { this.iteAlmDescResumen = iteAlmDescResumen; }
    public String getIteAlmUso() { return iteAlmUso; }
    public void setIteAlmUso(String iteAlmUso) { this.iteAlmUso = iteAlmUso; }
    public String getIteAlmUniMed() { return iteAlmUniMed; }
    public void setIteAlmUniMed(String iteAlmUniMed) { this.iteAlmUniMed = iteAlmUniMed; }
    public String getIteAlmCtaCompra() { return iteAlmCtaCompra; }
    public void setIteAlmCtaCompra(String iteAlmCtaCompra) { this.iteAlmCtaCompra = iteAlmCtaCompra; }
    public String getIteAlmCtaEntMat() { return iteAlmCtaEntMat; }
    public void setIteAlmCtaEntMat(String iteAlmCtaEntMat) { this.iteAlmCtaEntMat = iteAlmCtaEntMat; }
    public String getIteAlmCtaExist() { return iteAlmCtaExist; }
    public void setIteAlmCtaExist(String iteAlmCtaExist) { this.iteAlmCtaExist = iteAlmCtaExist; }
    public BigDecimal getIteAlmPrecio() { return iteAlmPrecio; }
    public void setIteAlmPrecio(BigDecimal iteAlmPrecio) { this.iteAlmPrecio = iteAlmPrecio; }
    public Integer getMonedaId() { return monedaId; }
    public void setMonedaId(Integer monedaId) { this.monedaId = monedaId; }
    public LocalDateTime getIteAlmUltFecAdq() { return iteAlmUltFecAdq; }
    public void setIteAlmUltFecAdq(LocalDateTime iteAlmUltFecAdq) { this.iteAlmUltFecAdq = iteAlmUltFecAdq; }
    public Boolean getIteAlmEstado() { return iteAlmEstado; }
    public void setIteAlmEstado(Boolean iteAlmEstado) { this.iteAlmEstado = iteAlmEstado; }
    public LocalDateTime getIteAlmFecBaja() { return iteAlmFecBaja; }
    public void setIteAlmFecBaja(LocalDateTime iteAlmFecBaja) { this.iteAlmFecBaja = iteAlmFecBaja; }
    public BigDecimal getIteAlmStockMin() { return iteAlmStockMin; }
    public void setIteAlmStockMin(BigDecimal iteAlmStockMin) { this.iteAlmStockMin = iteAlmStockMin; }
    public BigDecimal getIteAlmTasIGV() { return iteAlmTasIGV; }
    public void setIteAlmTasIGV(BigDecimal iteAlmTasIGV) { this.iteAlmTasIGV = iteAlmTasIGV; }
    public BigDecimal getIteAlmTasISC() { return iteAlmTasISC; }
    public void setIteAlmTasISC(BigDecimal iteAlmTasISC) { this.iteAlmTasISC = iteAlmTasISC; }
    public Boolean getIteAlmControlado() { return iteAlmControlado; }
    public void setIteAlmControlado(Boolean iteAlmControlado) { this.iteAlmControlado = iteAlmControlado; }
    public Integer getIteAlmFraccUni() { return iteAlmFraccUni; }
    public void setIteAlmFraccUni(Integer iteAlmFraccUni) { this.iteAlmFraccUni = iteAlmFraccUni; }
    public BigDecimal getIteAlmCosPro() { return iteAlmCosPro; }
    public void setIteAlmCosPro(BigDecimal iteAlmCosPro) { this.iteAlmCosPro = iteAlmCosPro; }
    public BigDecimal getIteAlmDscto() { return iteAlmDscto; }
    public void setIteAlmDscto(BigDecimal iteAlmDscto) { this.iteAlmDscto = iteAlmDscto; }
    public BigDecimal getIteAlmDsctoAdi() { return iteAlmDsctoAdi; }
    public void setIteAlmDsctoAdi(BigDecimal iteAlmDsctoAdi) { this.iteAlmDsctoAdi = iteAlmDsctoAdi; }
    public BigDecimal getIteAlmUtilidadVta() { return iteAlmUtilidadVta; }
    public void setIteAlmUtilidadVta(BigDecimal iteAlmUtilidadVta) { this.iteAlmUtilidadVta = iteAlmUtilidadVta; }
    public BigDecimal getIteAlmUtilidadSug() { return iteAlmUtilidadSug; }
    public void setIteAlmUtilidadSug(BigDecimal iteAlmUtilidadSug) { this.iteAlmUtilidadSug = iteAlmUtilidadSug; }
    public BigDecimal getIteAlmPVPF() { return iteAlmPVPF; }
    public void setIteAlmPVPF(BigDecimal iteAlmPVPF) { this.iteAlmPVPF = iteAlmPVPF; }
    public BigDecimal getIteAlmPreVta() { return iteAlmPreVta; }
    public void setIteAlmPreVta(BigDecimal iteAlmPreVta) { this.iteAlmPreVta = iteAlmPreVta; }
    public BigDecimal getIteAlmValorVtaFar() { return iteAlmValorVtaFar; }
    public void setIteAlmValorVtaFar(BigDecimal iteAlmValorVtaFar) { this.iteAlmValorVtaFar = iteAlmValorVtaFar; }
    public LocalDateTime getIteAlmFecVen() { return iteAlmFecVen; }
    public void setIteAlmFecVen(LocalDateTime iteAlmFecVen) { this.iteAlmFecVen = iteAlmFecVen; }
    public String getCodpro() { return codpro; }
    public void setCodpro(String codpro) { this.codpro = codpro; }
    public Boolean getItemAlmCtrlAdm() { return itemAlmCtrlAdm; }
    public void setItemAlmCtrlAdm(Boolean itemAlmCtrlAdm) { this.itemAlmCtrlAdm = itemAlmCtrlAdm; }
    public String getUnidMedId() { return unidMedId; }
    public void setUnidMedId(String unidMedId) { this.unidMedId = unidMedId; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
