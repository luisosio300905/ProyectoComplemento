package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;


public class BalanceGeneralResponse {
    private Long diaCabCompId;
    private String glosa;
    private BigDecimal totalDebe;
    private BigDecimal totalHaber;
    private String estado;
    private Integer detalleCount;

    public BalanceGeneralResponse() {}

    public BalanceGeneralResponse(Long diaCabCompId, String glosa, BigDecimal totalDebe, BigDecimal totalHaber, Integer detalleCount) {
        this.diaCabCompId = diaCabCompId;
        this.glosa = glosa;
        this.totalDebe = totalDebe != null ? totalDebe : BigDecimal.ZERO;
        this.totalHaber = totalHaber != null ? totalHaber : BigDecimal.ZERO;
        this.detalleCount = detalleCount;
        // Validar que el asiento esté balanceado
        this.estado = this.totalDebe.compareTo(this.totalHaber) == 0 ? "BALANCEADO" : "DESBALANCEADO";
    }

    // Getters
    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }

    public String getGlosa() { return glosa; }
    public void setGlosa(String glosa) { this.glosa = glosa; }

    public BigDecimal getTotalDebe() { return totalDebe; }
    public void setTotalDebe(BigDecimal totalDebe) { this.totalDebe = totalDebe; }

    public BigDecimal getTotalHaber() { return totalHaber; }
    public void setTotalHaber(BigDecimal totalHaber) { this.totalHaber = totalHaber; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Integer getDetalleCount() { return detalleCount; }
    public void setDetalleCount(Integer detalleCount) { this.detalleCount = detalleCount; }

    @Override
    public String toString() {
        return "BalanceGeneralResponse{" +
                "diaCabCompId=" + diaCabCompId +
                ", glosa='" + glosa + '\'' +
                ", totalDebe=" + totalDebe +
                ", totalHaber=" + totalHaber +
                ", estado='" + estado + '\'' +
                ", detalleCount=" + detalleCount +
                '}';
    }
}

