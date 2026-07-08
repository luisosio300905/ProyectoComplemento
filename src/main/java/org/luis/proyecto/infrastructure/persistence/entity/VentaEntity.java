package org.luis.proyecto.infrastructure.persistence.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "ComprobanteVentaCabecera")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detallesVenta;
    @Column(name = "EmpresaId")
    private String empresaId;

    @Column(name = "UnidComId")
    private Integer unidComId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DocId")
    private DocumentoEntity documento;

    @Column(name = "VtaCabNumComp")
    private String vtaCabNumComp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClienId")
    private ClienteEntity cliente;

    @Column(name = "MonedaId")
    private Integer monedaId;

    @Column(name = "VtaCabFecha")
    private LocalDateTime vtaCabFecha;

    @Column(name = "VtaValCamb")
    private BigDecimal vtaValCamb;

    @Column(name = "VtaCabAccImp")
    private String vtaCabAccImp;

    @Column(name = "VtaComAccAnu")
    private String vtaComAccAnu;

    @Column(name = "CondComId")
    private Integer condComId;

    @Column(name = "VtaCabEstCanc")
    private String vtaCabEstCanc;

    @Column(name = "VtaCabCierre")
    private String vtaCabCierre;

    @Column(name = "VtaCabActPlla")
    private String vtaCabActPlla;

    @Column(name = "VtaCabAfecDetrac")
    private String vtaCabAfecDetrac;

    @Column(name = "VtaCabContDetrac")
    private String vtaCabContDetrac;

    @Column(name = "TipOpeComId")
    private Integer tipOpeComId;

    @Column(name = "VtaCabNumRef")
    private Long vtaCabNumRef;

    @Column(name = "VtaCabValorVta")
    private BigDecimal vtaCabValorVta;

    @Column(name = "VtaCabValorVtaExo")
    private BigDecimal vtaCabValorVtaExo;

    @Column(name = "VtaCabValIGV")
    private BigDecimal vtaCabValIGV;

    @Column(name = "VtaCabValISC")
    private BigDecimal vtaCabValISC;

    @Column(name = "VtaCabValTotal")
    private BigDecimal vtaCabValTotal;

    @Column(name = "VtaCabValMonPago")
    private BigDecimal vtaCabValMonPago;

    @Column(name = "VtaCabValVuelto")
    private BigDecimal vtaCabValVuelto;

    @Column(name = "VtaCabNamePaciente")
    private String vtaCabNamePaciente;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @Column(name = "VtaCabDsctoGlobal")
    private BigDecimal vtaCabDsctoGlobal;

    @Column(name = "VtaCabFechaVcto")
    private LocalDateTime vtaCabFechaVcto;

    public VentaEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public List<DetalleVentaEntity> getDetallesVenta() { return detallesVenta; }
    public void setDetallesVenta(List<DetalleVentaEntity> detallesVenta) {
        if (this.detallesVenta == null) {
            this.detallesVenta = detallesVenta;
        } else {
            this.detallesVenta.clear();
            if (detallesVenta != null) {
                this.detallesVenta.addAll(detallesVenta);
            }
        }
    }
    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }
    public Integer getUnidComId() { return unidComId; }
    public void setUnidComId(Integer unidComId) { this.unidComId = unidComId; }
    public DocumentoEntity getDocumento() { return documento; }
    public void setDocumento(DocumentoEntity documento) { this.documento = documento; }
    public String getVtaCabNumComp() { return vtaCabNumComp; }
    public void setVtaCabNumComp(String vtaCabNumComp) { this.vtaCabNumComp = vtaCabNumComp; }
    public ClienteEntity getCliente() { return cliente; }
    public void setCliente(ClienteEntity cliente) { this.cliente = cliente; }
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
}
