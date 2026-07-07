package org.luis.proyecto.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

public class DivisionariaPK implements Serializable {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;

    public DivisionariaPK() {}

    public DivisionariaPK(String cuentaId, String subCtaId, String divisioId) {
        this.cuentaId = cuentaId;
        this.subCtaId = subCtaId;
        this.divisioId = divisioId;
    }

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionariaPK that = (DivisionariaPK) o;
        return Objects.equals(cuentaId, that.cuentaId) && Objects.equals(subCtaId, that.subCtaId) && Objects.equals(divisioId, that.divisioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaId, subCtaId, divisioId);
    }
}

