package org.luis.proyecto.domain.model;

import java.math.BigDecimal;

public class DetalleVenta {
    private Integer id;
    private Venta venta;
    private Producto producto;
    private BigDecimal subTotal;

    public DetalleVenta(Integer id, Venta venta, Producto producto, BigDecimal subTotal) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
        this.subTotal = subTotal;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
