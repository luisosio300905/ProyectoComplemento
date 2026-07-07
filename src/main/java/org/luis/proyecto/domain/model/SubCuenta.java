package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class SubCuenta {
    private String cuentaId;
    private String subCtaId;
    private String subCtaDescripcion;
    private Boolean subCtaEstado;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private List<Divisionaria> divisionarias;

    public SubCuenta() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getSubCtaDescripcion() { return subCtaDescripcion; }
    public void setSubCtaDescripcion(String subCtaDescripcion) { this.subCtaDescripcion = subCtaDescripcion; }

    public Boolean getSubCtaEstado() { return subCtaEstado; }
    public void setSubCtaEstado(Boolean subCtaEstado) { this.subCtaEstado = subCtaEstado; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public List<Divisionaria> getDivisionarias() { return divisionarias; }
    public void setDivisionarias(List<Divisionaria> divisionarias) { this.divisionarias = divisionarias; }
}

