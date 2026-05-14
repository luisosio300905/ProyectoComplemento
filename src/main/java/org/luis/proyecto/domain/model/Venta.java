package org.luis.proyecto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private Integer id;
    private LocalDateTime fecha;
    private BigDecimal total;
    private ComprobantePago comprobantePago;
    private List<DetalleVenta> detallesVenta;

    public Venta() {
    }

    public Venta(LocalDateTime fecha, BigDecimal total, ComprobantePago comprobantePago) {
        this.fecha = fecha;
        this.total = total;
        this.comprobantePago = comprobantePago;
    }

    public Venta(Integer id, LocalDateTime fecha, BigDecimal total, ComprobantePago comprobantePago) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.comprobantePago = comprobantePago;
    }
    
    public Integer getId() {
        return id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
}
