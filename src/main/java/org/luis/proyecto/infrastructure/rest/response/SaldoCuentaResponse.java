package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.SaldoCuenta;

import java.math.BigDecimal;

public class SaldoCuentaResponse {
    private String cuentaId;
    private String subCtaId;
    private String divisioId;
    private String subDivId;
    private BigDecimal totalDebe;
    private BigDecimal totalHaber;
    private BigDecimal saldo;

    public SaldoCuentaResponse() {}

    public SaldoCuentaResponse(String cuentaId, String subCtaId, String divisioId, String subDivId,
                               BigDecimal totalDebe, BigDecimal totalHaber) {
        this.cuentaId = cuentaId;
        this.subCtaId = subCtaId;
        this.divisioId = divisioId;
        this.subDivId = subDivId;
        this.totalDebe = totalDebe != null ? totalDebe : BigDecimal.ZERO;
        this.totalHaber = totalHaber != null ? totalHaber : BigDecimal.ZERO;
        this.saldo = this.totalDebe.subtract(this.totalHaber);
    }

    public static SaldoCuentaResponse from(SaldoCuenta saldoCuenta) {
        return new SaldoCuentaResponse(
                saldoCuenta.getCuentaId(),
                saldoCuenta.getSubCtaId(),
                saldoCuenta.getDivisioId(),
                saldoCuenta.getSubDivId(),
                saldoCuenta.getTotalDebe(),
                saldoCuenta.getTotalHaber()
        );
    }

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

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
}
