package org.luis.proyecto.infrastructure.persistence.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienId")
    private Integer id;

    @Column(name = "ClienDescripcion")
    private String clienDescripcion;

    @Column(name = "ClienRazSoc")
    private String clienRazSoc;

    @Column(name = "ClienNomCor")
    private String clienNomCor;

    @Column(name = "ClienSiglas")
    private String clienSiglas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipDocIdenId")
    private TipoDocumentoIdentidadEntity tipoDocumentoIdentidad;

    @Column(name = "ClienDoc")
    private String clienDoc;

    @Column(name = "ClienRegCom")
    private String clienRegCom;

    @Column(name = "ClienDireccion")
    private String clienDireccion;

    @Column(name = "ClienTelef01")
    private String clienTelef01;

    @Column(name = "ClienTelef02")
    private String clienTelef02;

    @Column(name = "ClienFax")
    private String clienFax;

    @Column(name = "ClienCelular")
    private String clienCelular;

    @Column(name = "ClienMail")
    private String clienMail;

    @Column(name = "ClienWeb")
    private String clienWeb;

    @Column(name = "ClienContacto")
    private String clienContacto;

    @Column(name = "ClienFecIng")
    private LocalDateTime clienFecIng;

    @Column(name = "ClienEstado")
    private String clienEstado;

    @Column(name = "ClienGiro")
    private String clienGiro;

    @Column(name = "ClienUltVta")
    private LocalDateTime clienUltVta;

    @Column(name = "CtaCteId")
    private Long ctaCteId;

    @Column(name = "DptoGeoId")
    private String dptoGeoId;

    @Column(name = "ProvGeoId")
    private String provGeoId;

    @Column(name = "DistGeoId")
    private String distGeoId;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    public ClienteEntity() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getClienDescripcion() { return clienDescripcion; }
    public void setClienDescripcion(String clienDescripcion) { this.clienDescripcion = clienDescripcion; }
    public String getClienRazSoc() { return clienRazSoc; }
    public void setClienRazSoc(String clienRazSoc) { this.clienRazSoc = clienRazSoc; }
    public String getClienNomCor() { return clienNomCor; }
    public void setClienNomCor(String clienNomCor) { this.clienNomCor = clienNomCor; }
    public String getClienSiglas() { return clienSiglas; }
    public void setClienSiglas(String clienSiglas) { this.clienSiglas = clienSiglas; }
    public TipoDocumentoIdentidadEntity getTipoDocumentoIdentidad() { return tipoDocumentoIdentidad; }
    public void setTipoDocumentoIdentidad(TipoDocumentoIdentidadEntity tipoDocumentoIdentidad) { this.tipoDocumentoIdentidad = tipoDocumentoIdentidad; }
    public String getClienDoc() { return clienDoc; }
    public void setClienDoc(String clienDoc) { this.clienDoc = clienDoc; }
    public String getClienRegCom() { return clienRegCom; }
    public void setClienRegCom(String clienRegCom) { this.clienRegCom = clienRegCom; }
    public String getClienDireccion() { return clienDireccion; }
    public void setClienDireccion(String clienDireccion) { this.clienDireccion = clienDireccion; }
    public String getClienTelef01() { return clienTelef01; }
    public void setClienTelef01(String clienTelef01) { this.clienTelef01 = clienTelef01; }
    public String getClienTelef02() { return clienTelef02; }
    public void setClienTelef02(String clienTelef02) { this.clienTelef02 = clienTelef02; }
    public String getClienFax() { return clienFax; }
    public void setClienFax(String clienFax) { this.clienFax = clienFax; }
    public String getClienCelular() { return clienCelular; }
    public void setClienCelular(String clienCelular) { this.clienCelular = clienCelular; }
    public String getClienMail() { return clienMail; }
    public void setClienMail(String clienMail) { this.clienMail = clienMail; }
    public String getClienWeb() { return clienWeb; }
    public void setClienWeb(String clienWeb) { this.clienWeb = clienWeb; }
    public String getClienContacto() { return clienContacto; }
    public void setClienContacto(String clienContacto) { this.clienContacto = clienContacto; }
    public LocalDateTime getClienFecIng() { return clienFecIng; }
    public void setClienFecIng(LocalDateTime clienFecIng) { this.clienFecIng = clienFecIng; }
    public String getClienEstado() { return clienEstado; }
    public void setClienEstado(String clienEstado) { this.clienEstado = clienEstado; }
    public String getClienGiro() { return clienGiro; }
    public void setClienGiro(String clienGiro) { this.clienGiro = clienGiro; }
    public LocalDateTime getClienUltVta() { return clienUltVta; }
    public void setClienUltVta(LocalDateTime clienUltVta) { this.clienUltVta = clienUltVta; }
    public Long getCtaCteId() { return ctaCteId; }
    public void setCtaCteId(Long ctaCteId) { this.ctaCteId = ctaCteId; }
    public String getDptoGeoId() { return dptoGeoId; }
    public void setDptoGeoId(String dptoGeoId) { this.dptoGeoId = dptoGeoId; }
    public String getProvGeoId() { return provGeoId; }
    public void setProvGeoId(String provGeoId) { this.provGeoId = provGeoId; }
    public String getDistGeoId() { return distGeoId; }
    public void setDistGeoId(String distGeoId) { this.distGeoId = distGeoId; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
