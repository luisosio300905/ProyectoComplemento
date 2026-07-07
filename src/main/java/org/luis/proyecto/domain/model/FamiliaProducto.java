package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class FamiliaProducto {
    private Integer id;
    private String famDescripcion;
    private Boolean famEstado;
    private String codfam;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public FamiliaProducto() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFamDescripcion() { return famDescripcion; }
    public void setFamDescripcion(String famDescripcion) { this.famDescripcion = famDescripcion; }
    public Boolean getFamEstado() { return famEstado; }
    public void setFamEstado(Boolean famEstado) { this.famEstado = famEstado; }
    public String getCodfam() { return codfam; }
    public void setCodfam(String codfam) { this.codfam = codfam; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
