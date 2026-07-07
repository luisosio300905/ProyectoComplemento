package org.luis.proyecto.domain.model;
import java.time.LocalDateTime;

public class Documento {
    private String id;
    private String docDescripcion;
    private String docDesCorta;
    private String docAbrev;
    private Boolean docEstado;
    private ComprobantePago comprobantePago;
    private Integer docNumDigSerie;
    private Integer docNumDigNumero;
    private Boolean docAfaNumerico;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public Documento() {}

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
    public ComprobantePago getComprobantePago() { return comprobantePago; }
    public void setComprobantePago(ComprobantePago comprobantePago) { this.comprobantePago = comprobantePago; }
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
