package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * Balance general calculado en tiempo real agrupando DiarioDetalle
 * por empresa y periodo (año/mes).
 */
public class EstadoBalanceGeneralResponse {
    private String empresaId;
    private Integer ano;
    private Integer mes;
    private BigDecimal totalDebe;
    private BigDecimal totalHaber;
    private String estado;
    private List<SaldoCuentaResponse> saldos;

    public EstadoBalanceGeneralResponse() {}

    public EstadoBalanceGeneralResponse(String empresaId, Integer ano, Integer mes,
                                        BigDecimal totalDebe, BigDecimal totalHaber,
                                        List<SaldoCuentaResponse> saldos) {
        this.empresaId = empresaId;
        this.ano = ano;
        this.mes = mes;
        this.totalDebe = totalDebe != null ? totalDebe : BigDecimal.ZERO;
        this.totalHaber = totalHaber != null ? totalHaber : BigDecimal.ZERO;
        this.estado = this.totalDebe.compareTo(this.totalHaber) == 0 ? "BALANCEADO" : "DESBALANCEADO";
        this.saldos = saldos;
    }

    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public BigDecimal getTotalDebe() { return totalDebe; }
    public void setTotalDebe(BigDecimal totalDebe) { this.totalDebe = totalDebe; }

    public BigDecimal getTotalHaber() { return totalHaber; }
    public void setTotalHaber(BigDecimal totalHaber) { this.totalHaber = totalHaber; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<SaldoCuentaResponse> getSaldos() { return saldos; }
    public void setSaldos(List<SaldoCuentaResponse> saldos) { this.saldos = saldos; }
}
