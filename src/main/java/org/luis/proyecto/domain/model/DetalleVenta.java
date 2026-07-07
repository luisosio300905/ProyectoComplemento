package org.luis.proyecto.domain.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalleVenta {
    private Integer id;
    private Venta venta;
    private String empresaId;
    private Integer unidComId;
    private String docId;
    private String vtaCabNumComp;
    private Integer iteAlmId;
    private Integer vtaDetCodref;
    private String vtaDetItem;
    private BigDecimal vtaDetCantidad;
    private BigDecimal vtaDetPrecUnit;
    private BigDecimal vtaDetValorVta;
    private BigDecimal vtaDetValIGV;
    private BigDecimal vtaDetValISC;
    private BigDecimal vtaDetValTot;
    private Integer tipVtaId;
    private Integer tipAlmId;
    private Integer almacenId;
    private Integer vtaDetFracUni;
    private Integer vtaDetCantFrac;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private BigDecimal vtaDetValIna;

    public DetalleVenta() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }
    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }
    public Integer getUnidComId() { return unidComId; }
    public void setUnidComId(Integer unidComId) { this.unidComId = unidComId; }
    public String getDocId() { return docId; }
    public void setDocId(String docId) { this.docId = docId; }
    public String getVtaCabNumComp() { return vtaCabNumComp; }
    public void setVtaCabNumComp(String vtaCabNumComp) { this.vtaCabNumComp = vtaCabNumComp; }
    public Integer getIteAlmId() { return iteAlmId; }
    public void setIteAlmId(Integer iteAlmId) { this.iteAlmId = iteAlmId; }
    public Integer getVtaDetCodref() { return vtaDetCodref; }
    public void setVtaDetCodref(Integer vtaDetCodref) { this.vtaDetCodref = vtaDetCodref; }
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
