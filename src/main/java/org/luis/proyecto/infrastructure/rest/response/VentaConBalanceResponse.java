package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;

/**
 * DTO enriquecido para la respuesta de creación de venta.
 * Incluye información de la venta y automáticamente el balance general
 * del asiento contable generado.
 */
public class VentaConBalanceResponse {
    private Integer ventaId;
    private String numComprobante;
    private BigDecimal totalVenta;
    private Long diaCabCompId;  // ID de la cabecera del asiento generado
    private BigDecimal totalDebe;
    private BigDecimal totalHaber;
    private String estadoAsiento;

    public VentaConBalanceResponse() {}

    public VentaConBalanceResponse(Integer ventaId, String numComprobante, BigDecimal totalVenta,
                                   Long diaCabCompId, BigDecimal totalDebe, BigDecimal totalHaber) {
        this.ventaId = ventaId;
        this.numComprobante = numComprobante;
        this.totalVenta = totalVenta;
        this.diaCabCompId = diaCabCompId;
        this.totalDebe = totalDebe != null ? totalDebe : BigDecimal.ZERO;
        this.totalHaber = totalHaber != null ? totalHaber : BigDecimal.ZERO;
        this.estadoAsiento = this.totalDebe.compareTo(this.totalHaber) == 0 ? "BALANCEADO" : "DESBALANCEADO";
    }

    // Getters y Setters
    public Integer getVentaId() { return ventaId; }
    public void setVentaId(Integer ventaId) { this.ventaId = ventaId; }

    public String getNumComprobante() { return numComprobante; }
    public void setNumComprobante(String numComprobante) { this.numComprobante = numComprobante; }

    public BigDecimal getTotalVenta() { return totalVenta; }
    public void setTotalVenta(BigDecimal totalVenta) { this.totalVenta = totalVenta; }

    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }

    public BigDecimal getTotalDebe() { return totalDebe; }
    public void setTotalDebe(BigDecimal totalDebe) { this.totalDebe = totalDebe; }

    public BigDecimal getTotalHaber() { return totalHaber; }
    public void setTotalHaber(BigDecimal totalHaber) { this.totalHaber = totalHaber; }

    public String getEstadoAsiento() { return estadoAsiento; }
    public void setEstadoAsiento(String estadoAsiento) { this.estadoAsiento = estadoAsiento; }

    @Override
    public String toString() {
        return "VentaConBalanceResponse{" +
                "ventaId=" + ventaId +
                ", numComprobante='" + numComprobante + '\'' +
                ", totalVenta=" + totalVenta +
                ", diaCabCompId=" + diaCabCompId +
                ", totalDebe=" + totalDebe +
                ", totalHaber=" + totalHaber +
                ", estadoAsiento='" + estadoAsiento + '\'' +
                '}';
    }
}

