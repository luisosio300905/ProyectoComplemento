package org.luis.proyecto.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

public class SubCuentaPK implements Serializable {
    private String cuentaId;
    private String subCtaId;

    public SubCuentaPK() {}

    public SubCuentaPK(String cuentaId, String subCtaId) {
        this.cuentaId = cuentaId;
        this.subCtaId = subCtaId;
    }

    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCuentaPK that = (SubCuentaPK) o;
        return Objects.equals(cuentaId, that.cuentaId) && Objects.equals(subCtaId, that.subCtaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaId, subCtaId);
    }
}

