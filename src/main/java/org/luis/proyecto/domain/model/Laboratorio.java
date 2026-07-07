package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class Laboratorio {
    private Integer id;
    private String labDescripcion;
    private Boolean labEstado;
    private String codlab;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public Laboratorio() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLabDescripcion() { return labDescripcion; }
    public void setLabDescripcion(String labDescripcion) { this.labDescripcion = labDescripcion; }
    public Boolean getLabEstado() { return labEstado; }
    public void setLabEstado(Boolean labEstado) { this.labEstado = labEstado; }
    public String getCodlab() { return codlab; }
    public void setCodlab(String codlab) { this.codlab = codlab; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
