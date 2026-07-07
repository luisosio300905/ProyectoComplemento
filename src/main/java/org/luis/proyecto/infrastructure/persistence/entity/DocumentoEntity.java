package org.luis.proyecto.infrastructure.persistence.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Documento")
public class DocumentoEntity {
    @Id
    @Column(name = "DocId", length = 50)
    private String id;

    @Column(name = "DocDescripcion")
    private String docDescripcion;

    @Column(name = "DocDesCorta")
    private String docDesCorta;

    @Column(name = "DocAbrev")
    private String docAbrev;

    @Column(name = "DocEstado")
    private Boolean docEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ComPagId")
    private ComprobantePagoEntity comprobantePago;

    @Column(name = "DocNumDigSerie")
    private Integer docNumDigSerie;

    @Column(name = "DocNumDigNumero")
    private Integer docNumDigNumero;

    @Column(name = "DocAfaNumerico")
    private Boolean docAfaNumerico;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    public DocumentoEntity() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDocDescripcion() { return docDescripcion; }
    public void setDocDescripcion(String docDescripcion) { this.docDescripcion = docDescripcion; }
    public String getDocDesCorta() { return docDesCorta; }
    public void setDocDesCorta(String docDesCorta) { this.docDesCorta = docDesCorta; }
    public String getDocAbrev() { return docAbrev; }
    public void setDocAbrev(String docAbrev) { this.docAbrev = docAbrev; }
    public Boolean getDocEstado() { return docEstado; }
    public void setDocEstado(Boolean docEstado) { this.docEstado = docEstado; }
    public ComprobantePagoEntity getComprobantePago() { return comprobantePago; }
    public void setComprobantePago(ComprobantePagoEntity comprobantePago) { this.comprobantePago = comprobantePago; }
    public Integer getDocNumDigSerie() { return docNumDigSerie; }
    public void setDocNumDigSerie(Integer docNumDigSerie) { this.docNumDigSerie = docNumDigSerie; }
    public Integer getDocNumDigNumero() { return docNumDigNumero; }
    public void setDocNumDigNumero(Integer docNumDigNumero) { this.docNumDigNumero = docNumDigNumero; }
    public Boolean getDocAfaNumerico() { return docAfaNumerico; }
    public void setDocAfaNumerico(Boolean docAfaNumerico) { this.docAfaNumerico = docAfaNumerico; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
