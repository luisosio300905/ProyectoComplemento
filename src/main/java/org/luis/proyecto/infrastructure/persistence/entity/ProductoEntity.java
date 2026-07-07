package org.luis.proyecto.infrastructure.persistence.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "ItemAlmacen")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IteAlmId")
    private Integer iteAlmId;
    @Column(name = "GrpAlmId")
    private String grpAlmId;
    @Column(name = "ClsAlmId")
    private String clsAlmId;
    @Column(name = "IteAlmCodBarra")
    private String iteAlmCodBarra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LabId")
    private LaboratorioEntity laboratorio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FamId")
    private FamiliaProductoEntity familiaProducto;
    @Column(name = "ComGenId")
    private Integer comGenId;
    @Column(name = "IteAlmDescDetalle")
    private String iteAlmDescDetalle;
    @Column(name = "IteAlmDescResumen")
    private String iteAlmDescResumen;
    @Column(name = "IteAlmUso")
    private String iteAlmUso;
    @Column(name = "IteAlmUniMed")
    private String iteAlmUniMed;
    @Column(name = "IteAlmCtaCompra")
    private String iteAlmCtaCompra;
    @Column(name = "IteAlmCtaEntMat")
    private String iteAlmCtaEntMat;
    @Column(name = "IteAlmCtaExist")
    private String iteAlmCtaExist;
    @Column(name = "IteAlmPrecio")
    private BigDecimal iteAlmPrecio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MonedaId")
    private MonedaEntity moneda;
    @Column(name = "IteAlmUltFecAdq")
    private LocalDateTime iteAlmUltFecAdq;
    @Column(name = "IteAlmEstado")
    private Boolean iteAlmEstado;
    @Column(name = "IteAlmFecBaja")
    private LocalDateTime iteAlmFecBaja;
    @Column(name = "IteAlmStockMin")
    private BigDecimal iteAlmStockMin;
    @Column(name = "IteAlmTasIGV")
    private BigDecimal iteAlmTasIGV;
    @Column(name = "IteAlmTasISC")
    private BigDecimal iteAlmTasISC;
    @Column(name = "IteAlmControlado")
    private Boolean iteAlmControlado;
    @Column(name = "IteAlmFraccUni")
    private Integer iteAlmFraccUni;
    @Column(name = "IteAlmCosPro")
    private BigDecimal iteAlmCosPro;
    @Column(name = "IteAlmDscto")
    private BigDecimal iteAlmDscto;
    @Column(name = "IteAlmDsctoAdi")
    private BigDecimal iteAlmDsctoAdi;
    @Column(name = "IteAlmUtilidadVta")
    private BigDecimal iteAlmUtilidadVta;
    @Column(name = "IteAlmUtilidadSug")
    private BigDecimal iteAlmUtilidadSug;
    @Column(name = "IteAlmPVPF")
    private BigDecimal iteAlmPVPF;
    @Column(name = "IteAlmPreVta")
    private BigDecimal iteAlmPreVta;
    @Column(name = "IteAlmValorVtaFar")
    private BigDecimal iteAlmValorVtaFar;
    @Column(name = "IteAlmFecVen")
    private LocalDateTime iteAlmFecVen;
    @Column(name = "codpro")
    private String codpro;
    @Column(name = "ItemAlmCtrlAdm")
    private Boolean itemAlmCtrlAdm;
    @Column(name = "UnidMedId")
    private String unidMedId;
    @Column(name = "UsrSistema")
    private String usrSistema;
    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;
    @Column(name = "HrsSistema")
    private String hrsSistema;

    public ProductoEntity() {}
    public Integer getIteAlmId() { return iteAlmId; }
    public void setIteAlmId(Integer id) { this.iteAlmId = id; }
    public String getGrpAlmId() { return grpAlmId; }
    public void setGrpAlmId(String grpAlmId) { this.grpAlmId = grpAlmId; }
    public String getClsAlmId() { return clsAlmId; }
    public void setClsAlmId(String clsAlmId) { this.clsAlmId = clsAlmId; }
    public String getIteAlmCodBarra() { return iteAlmCodBarra; }
    public void setIteAlmCodBarra(String iteAlmCodBarra) { this.iteAlmCodBarra = iteAlmCodBarra; }
    public LaboratorioEntity getLaboratorio() { return laboratorio; }
    public void setLaboratorio(LaboratorioEntity laboratorio) { this.laboratorio = laboratorio; }
    public FamiliaProductoEntity getFamiliaProducto() { return familiaProducto; }
    public void setFamiliaProducto(FamiliaProductoEntity familiaProducto) { this.familiaProducto = familiaProducto; }
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
    public MonedaEntity getMoneda() { return moneda; }
    public void setMoneda(MonedaEntity moneda) { this.moneda = moneda; }
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
