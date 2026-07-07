package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class Moneda {
    private Integer id;
    private String monedaDescripcion;
    private String monedaAbrev;
    private Boolean monedaEst;
    private String monedaAbrevSunat;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public Moneda() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMonedaDescripcion() { return monedaDescripcion; }
    public void setMonedaDescripcion(String monedaDescripcion) { this.monedaDescripcion = monedaDescripcion; }
    public String getMonedaAbrev() { return monedaAbrev; }
    public void setMonedaAbrev(String monedaAbrev) { this.monedaAbrev = monedaAbrev; }
    public Boolean getMonedaEst() { return monedaEst; }
    public void setMonedaEst(Boolean monedaEst) { this.monedaEst = monedaEst; }
    public String getMonedaAbrevSunat() { return monedaAbrevSunat; }
    public void setMonedaAbrevSunat(String monedaAbrevSunat) { this.monedaAbrevSunat = monedaAbrevSunat; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
