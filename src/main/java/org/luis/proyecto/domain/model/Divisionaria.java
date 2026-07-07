package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Divisionaria {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String divisioDescripcion;
    private Boolean divisioEstad;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private List<SubDivisionaria> subDivisionarias;

    public Divisionaria() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getDivisioDescripcion() { return divisioDescripcion; }
    public void setDivisioDescripcion(String divisioDescripcion) { this.divisioDescripcion = divisioDescripcion; }

    public Boolean getDivisioEstad() { return divisioEstad; }
    public void setDivisioEstad(Boolean divisioEstad) { this.divisioEstad = divisioEstad; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public List<SubDivisionaria> getSubDivisionarias() { return subDivisionarias; }
    public void setSubDivisionarias(List<SubDivisionaria> subDivisionarias) { this.subDivisionarias = subDivisionarias; }
}

