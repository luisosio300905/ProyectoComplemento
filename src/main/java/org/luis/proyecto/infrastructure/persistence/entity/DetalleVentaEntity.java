package org.luis.proyecto.infrastructure.persistence.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ComprobanteVentaDetalle")
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private VentaEntity venta;

    @Column(name = "EmpresaId")
    private String empresaId;

    @Column(name = "UnidComId")
    private Integer unidComId;

    @Column(name = "DocId")
    private String docId;

    @Column(name = "VtaCabNumComp")
    private String vtaCabNumComp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IteAlmId")
    private ProductoEntity producto;

    @Column(name = "VtaDetCodref")
    private Integer vtaDetCodref;

    @Column(name = "VtaDetItem")
    private String vtaDetItem;

    @Column(name = "VtaDetCantidad")
    private BigDecimal vtaDetCantidad;

    @Column(name = "VtaDetPrecUnit")
    private BigDecimal vtaDetPrecUnit;

    @Column(name = "VtaDetValorVta")
    private BigDecimal vtaDetValorVta;

    @Column(name = "VtaDetValIGV")
    private BigDecimal vtaDetValIGV;

    @Column(name = "VtaDetValISC")
    private BigDecimal vtaDetValISC;

    @Column(name = "VtaDetValTot")
    private BigDecimal vtaDetValTot;

    @Column(name = "TipVtaId")
    private Integer tipVtaId;

    @Column(name = "TipAlmId")
    private Integer tipAlmId;

    @Column(name = "AlmacenId")
    private Integer almacenId;

    @Column(name = "VtaDetFracUni")
    private Integer vtaDetFracUni;

    @Column(name = "VtaDetCantFrac")
    private Integer vtaDetCantFrac;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @Column(name = "VtaDetValIna")
    private BigDecimal vtaDetValIna;

    public DetalleVentaEntity() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public VentaEntity getVenta() { return venta; }
    public void setVenta(VentaEntity venta) { this.venta = venta; }
    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }
    public Integer getUnidComId() { return unidComId; }
    public void setUnidComId(Integer unidComId) { this.unidComId = unidComId; }
    public String getDocId() { return docId; }
    public void setDocId(String docId) { this.docId = docId; }
    public String getVtaCabNumComp() { return vtaCabNumComp; }
    public void setVtaCabNumComp(String vtaCabNumComp) { this.vtaCabNumComp = vtaCabNumComp; }
    public ProductoEntity getProducto() { return producto; }
    public void setProducto(ProductoEntity producto) { this.producto = producto; }
    public String getVtaDetItem() { return vtaDetItem; }
    public void setVtaDetItem(String vtaDetItem) { this.vtaDetItem = vtaDetItem; }
    public BigDecimal getVtaDetCantidad() { return vtaDetCantidad; }
    public void setVtaDetCantidad(BigDecimal vtaDetCantidad) { this.vtaDetCantidad = vtaDetCantidad; }
    public BigDecimal getVtaDetPrecUnit() { return vtaDetPrecUnit; }
    public void setVtaDetPrecUnit(BigDecimal vtaDetPrecUnit) { this.vtaDetPrecUnit = vtaDetPrecUnit; }
    public BigDecimal getVtaDetValorVta() { return vtaDetValorVta; }
    public void setVtaDetValorVta(BigDecimal vtaDetValorVta) { this.vtaDetValorVta = vtaDetValorVta; }
    public BigDecimal getVtaDetValIGV() { return vtaDetValIGV; }
    public void setVtaDetValIGV(BigDecimal vtaDetValIGV) { this.vtaDetValIGV = vtaDetValIGV; }
    public BigDecimal getVtaDetValISC() { return vtaDetValISC; }
    public void setVtaDetValISC(BigDecimal vtaDetValISC) { this.vtaDetValISC = vtaDetValISC; }
    public BigDecimal getVtaDetValTot() { return vtaDetValTot; }
    public void setVtaDetValTot(BigDecimal vtaDetValTot) { this.vtaDetValTot = vtaDetValTot; }
    public Integer getTipVtaId() { return tipVtaId; }
    public void setTipVtaId(Integer tipVtaId) { this.tipVtaId = tipVtaId; }
    public Integer getTipAlmId() { return tipAlmId; }
    public void setTipAlmId(Integer tipAlmId) { this.tipAlmId = tipAlmId; }
    public Integer getAlmacenId() { return almacenId; }
    public void setAlmacenId(Integer almacenId) { this.almacenId = almacenId; }
    public Integer getVtaDetFracUni() { return vtaDetFracUni; }
    public void setVtaDetFracUni(Integer vtaDetFracUni) { this.vtaDetFracUni = vtaDetFracUni; }
    public Integer getVtaDetCantFrac() { return vtaDetCantFrac; }
    public void setVtaDetCantFrac(Integer vtaDetCantFrac) { this.vtaDetCantFrac = vtaDetCantFrac; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
    public BigDecimal getVtaDetValIna() { return vtaDetValIna; }
    public void setVtaDetValIna(BigDecimal vtaDetValIna) { this.vtaDetValIna = vtaDetValIna; }
}
