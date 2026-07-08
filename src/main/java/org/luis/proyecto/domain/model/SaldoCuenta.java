package org.luis.proyecto.domain.model;

import java.math.BigDecimal;

/**
 * Saldo agregado (suma de debe y haber) de una cuenta contable al máximo nivel de
 * detalle (Cuenta / SubCuenta / Divisionaria / SubDivisionaria).
 * Es el resultado de agrupar los DiarioDetalle y es la base para construir el
 * Balance General.
 */
public class SaldoCuenta {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String subDivId;
    private BigDecimal totalDebe;
    private BigDecimal totalHaber;

    public SaldoCuenta() {}

    public SaldoCuenta(String cuentaId, String subCtaId, String divisioId, String subDivId,
                       BigDecimal totalDebe, BigDecimal totalHaber) {
        this.cuentaId = cuentaId;
        this.subCtaId = subCtaId;
        this.divisioId = divisioId;
        this.subDivId = subDivId;
        this.totalDebe = totalDebe != null ? totalDebe : BigDecimal.ZERO;
        this.totalHaber = totalHaber != null ? totalHaber : BigDecimal.ZERO;
    }

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getSubDivId() { return subDivId; }
    public void setSubDivId(String subDivId) { this.subDivId = subDivId; }

    public BigDecimal getTotalDebe() { return totalDebe; }
    public void setTotalDebe(BigDecimal totalDebe) { this.totalDebe = totalDebe; }

    public BigDecimal getTotalHaber() { return totalHaber; }
    public void setTotalHaber(BigDecimal totalHaber) { this.totalHaber = totalHaber; }
}
