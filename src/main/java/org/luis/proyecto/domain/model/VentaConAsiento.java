package org.luis.proyecto.domain.model;

/**
 * Modelo auxiliar para transportar la información de venta
 * junto con el ID del asiento contable generado.
 */
public class VentaConAsiento {
    private Venta venta;
    private Long diaCabCompId;  // ID de la DiarioCabecera generada

    public VentaConAsiento(Venta venta, Long diaCabCompId) {
        this.venta = venta;
        this.diaCabCompId = diaCabCompId;
    }

    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }

    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }
}

