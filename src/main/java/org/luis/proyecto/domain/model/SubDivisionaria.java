package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class SubDivisionaria {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String subDivId;
    private String subDivDescripcion;
    private Boolean subDivCenCost;
    private Boolean subDivCtaCte;
    private Boolean subDivAnalisis;
    private Boolean subDivEstado;
    private Integer tipCtaId;
    private Integer subDivNumDigSunat;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private String cta5;
    private String cta8;

    public SubDivisionaria() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getSubDivId() { return subDivId; }
    public void setSubDivId(String subDivId) { this.subDivId = subDivId; }

    public String getSubDivDescripcion() { return subDivDescripcion; }
    public void setSubDivDescripcion(String subDivDescripcion) { this.subDivDescripcion = subDivDescripcion; }

    public Boolean getSubDivCenCost() { return subDivCenCost; }
    public void setSubDivCenCost(Boolean subDivCenCost) { this.subDivCenCost = subDivCenCost; }

    public Boolean getSubDivCtaCte() { return subDivCtaCte; }
    public void setSubDivCtaCte(Boolean subDivCtaCte) { this.subDivCtaCte = subDivCtaCte; }

    public Boolean getSubDivAnalisis() { return subDivAnalisis; }
    public void setSubDivAnalisis(Boolean subDivAnalisis) { this.subDivAnalisis = subDivAnalisis; }

    public Boolean getSubDivEstado() { return subDivEstado; }
    public void setSubDivEstado(Boolean subDivEstado) { this.subDivEstado = subDivEstado; }

    public Integer getTipCtaId() { return tipCtaId; }
    public void setTipCtaId(Integer tipCtaId) { this.tipCtaId = tipCtaId; }

    public Integer getSubDivNumDigSunat() { return subDivNumDigSunat; }
    public void setSubDivNumDigSunat(Integer subDivNumDigSunat) { this.subDivNumDigSunat = subDivNumDigSunat; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public String getCta5() { return cta5; }
    public void setCta5(String cta5) { this.cta5 = cta5; }

    public String getCta8() { return cta8; }
    public void setCta8(String cta8) { this.cta8 = cta8; }
}

