package org.luis.proyecto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Compra {
    private Integer id;
    private LocalDateTime fecha;
    private BigDecimal total;
    private Proveedor proveedor;
    private ComprobantePago comprobantePago;

    public Compra() {
    }

    public Compra(LocalDateTime fecha, BigDecimal total, Proveedor proveedor, ComprobantePago comprobantePago) {
        this.fecha = fecha;
        this.total = total;
        this.proveedor = proveedor;
        this.comprobantePago = comprobantePago;
    }

    public Compra(Integer id, LocalDateTime fecha, BigDecimal total, Proveedor proveedor, ComprobantePago comprobantePago) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.proveedor = proveedor;
        this.comprobantePago = comprobantePago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
}


