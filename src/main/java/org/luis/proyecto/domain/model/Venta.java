package org.luis.proyecto.domain.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
public class Venta {
    private Integer id;
    private Long diaCabCompId;
    private List<DetalleVenta> detallesVenta;
    private String empresaId;
    private Integer unidComId;
    private String docId;
    private String vtaCabNumComp;
    private Long clienId;
    private Integer monedaId;
    private LocalDateTime vtaCabFecha;
    private BigDecimal vtaValCamb;
    private String vtaCabAccImp;
    private String vtaComAccAnu;
    private Integer condComId;
    private String vtaCabEstCanc;
    private String vtaCabCierre;
    private String vtaCabActPlla;
    private String vtaCabAfecDetrac;
    private String vtaCabContDetrac;
    private Integer tipOpeComId;
    private Long vtaCabNumRef;
    private BigDecimal vtaCabValorVta;
    private BigDecimal vtaCabValorVtaExo;
    private BigDecimal vtaCabValIGV;
    private BigDecimal vtaCabValISC;
    private BigDecimal vtaCabValTotal;
    private BigDecimal vtaCabValMonPago;
    private BigDecimal vtaCabValVuelto;
    private String vtaCabNamePaciente;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private BigDecimal vtaCabDsctoGlobal;
    private LocalDateTime vtaCabFechaVcto;

    // Constructor empty
    public Venta() {}

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public List<DetalleVenta> getDetallesVenta() { return detallesVenta; }
    public void setDetallesVenta(List<DetalleVenta> detallesVenta) { this.detallesVenta = detallesVenta; }
    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }
    public Integer getUnidComId() { return unidComId; }
    public void setUnidComId(Integer unidComId) { this.unidComId = unidComId; }
    public String getDocId() { return docId; }
    public void setDocId(String docId) { this.docId = docId; }
    public String getVtaCabNumComp() { return vtaCabNumComp; }
    public void setVtaCabNumComp(String vtaCabNumComp) { this.vtaCabNumComp = vtaCabNumComp; }
    public Long getClienId() { return clienId; }
    public void setClienId(Long clienId) { this.clienId = clienId; }
    public Integer getMonedaId() { return monedaId; }
    public void setMonedaId(Integer monedaId) { this.monedaId = monedaId; }
    public LocalDateTime getVtaCabFecha() { return vtaCabFecha; }
    public void setVtaCabFecha(LocalDateTime vtaCabFecha) { this.vtaCabFecha = vtaCabFecha; }
    public BigDecimal getVtaValCamb() { return vtaValCamb; }
    public void setVtaValCamb(BigDecimal vtaValCamb) { this.vtaValCamb = vtaValCamb; }
    public String getVtaCabAccImp() { return vtaCabAccImp; }
    public void setVtaCabAccImp(String vtaCabAccImp) { this.vtaCabAccImp = vtaCabAccImp; }
    public String getVtaComAccAnu() { return vtaComAccAnu; }
    public void setVtaComAccAnu(String vtaComAccAnu) { this.vtaComAccAnu = vtaComAccAnu; }
    public Integer getCondComId() { return condComId; }
    public void setCondComId(Integer condComId) { this.condComId = condComId; }
    public String getVtaCabEstCanc() { return vtaCabEstCanc; }
    public void setVtaCabEstCanc(String vtaCabEstCanc) { this.vtaCabEstCanc = vtaCabEstCanc; }
    public String getVtaCabCierre() { return vtaCabCierre; }
    public void setVtaCabCierre(String vtaCabCierre) { this.vtaCabCierre = vtaCabCierre; }
    public String getVtaCabActPlla() { return vtaCabActPlla; }
    public void setVtaCabActPlla(String vtaCabActPlla) { this.vtaCabActPlla = vtaCabActPlla; }
    public String getVtaCabAfecDetrac() { return vtaCabAfecDetrac; }
    public void setVtaCabAfecDetrac(String vtaCabAfecDetrac) { this.vtaCabAfecDetrac = vtaCabAfecDetrac; }
    public String getVtaCabContDetrac() { return vtaCabContDetrac; }
    public void setVtaCabContDetrac(String vtaCabContDetrac) { this.vtaCabContDetrac = vtaCabContDetrac; }
    public Integer getTipOpeComId() { return tipOpeComId; }
    public void setTipOpeComId(Integer tipOpeComId) { this.tipOpeComId = tipOpeComId; }
    public Long getVtaCabNumRef() { return vtaCabNumRef; }
    public void setVtaCabNumRef(Long vtaCabNumRef) { this.vtaCabNumRef = vtaCabNumRef; }
    public BigDecimal getVtaCabValorVta() { return vtaCabValorVta; }
    public void setVtaCabValorVta(BigDecimal vtaCabValorVta) { this.vtaCabValorVta = vtaCabValorVta; }
    public BigDecimal getVtaCabValorVtaExo() { return vtaCabValorVtaExo; }
    public void setVtaCabValorVtaExo(BigDecimal vtaCabValorVtaExo) { this.vtaCabValorVtaExo = vtaCabValorVtaExo; }
    public BigDecimal getVtaCabValIGV() { return vtaCabValIGV; }
    public void setVtaCabValIGV(BigDecimal vtaCabValIGV) { this.vtaCabValIGV = vtaCabValIGV; }
    public BigDecimal getVtaCabValISC() { return vtaCabValISC; }
    public void setVtaCabValISC(BigDecimal vtaCabValISC) { this.vtaCabValISC = vtaCabValISC; }
    public BigDecimal getVtaCabValTotal() { return vtaCabValTotal; }
    public void setVtaCabValTotal(BigDecimal vtaCabValTotal) { this.vtaCabValTotal = vtaCabValTotal; }
    public BigDecimal getVtaCabValMonPago() { return vtaCabValMonPago; }
    public void setVtaCabValMonPago(BigDecimal vtaCabValMonPago) { this.vtaCabValMonPago = vtaCabValMonPago; }
    public BigDecimal getVtaCabValVuelto() { return vtaCabValVuelto; }
    public void setVtaCabValVuelto(BigDecimal vtaCabValVuelto) { this.vtaCabValVuelto = vtaCabValVuelto; }
    public String getVtaCabNamePaciente() { return vtaCabNamePaciente; }
    public void setVtaCabNamePaciente(String vtaCabNamePaciente) { this.vtaCabNamePaciente = vtaCabNamePaciente; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
    public BigDecimal getVtaCabDsctoGlobal() { return vtaCabDsctoGlobal; }
    public void setVtaCabDsctoGlobal(BigDecimal vtaCabDsctoGlobal) { this.vtaCabDsctoGlobal = vtaCabDsctoGlobal; }
    public LocalDateTime getVtaCabFechaVcto() { return vtaCabFechaVcto; }
    public void setVtaCabFechaVcto(LocalDateTime vtaCabFechaVcto) { this.vtaCabFechaVcto = vtaCabFechaVcto; }
    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }
}
