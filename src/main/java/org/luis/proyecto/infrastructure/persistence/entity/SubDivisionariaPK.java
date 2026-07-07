package org.luis.proyecto.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

public class SubDivisionariaPK implements Serializable {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String subDivId;

    public SubDivisionariaPK() {}

    public SubDivisionariaPK(String cuentaId, String subCtaId, String divisioId, String subDivId) {
        this.cuentaId = cuentaId;
        this.subCtaId = subCtaId;
        this.divisioId = divisioId;
        this.subDivId = subDivId;
    }

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getSubDivId() { return subDivId; }
    public void setSubDivId(String subDivId) { this.subDivId = subDivId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubDivisionariaPK that = (SubDivisionariaPK) o;
        return Objects.equals(cuentaId, that.cuentaId) && Objects.equals(subCtaId, that.subCtaId) && Objects.equals(divisioId, that.divisioId) && Objects.equals(subDivId, that.subDivId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaId, subCtaId, divisioId, subDivId);
    }
}

