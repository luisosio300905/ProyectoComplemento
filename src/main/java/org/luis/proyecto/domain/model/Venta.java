package org.luis.proyecto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta {
    private Integer id;
    private LocalDateTime fecha;
    private BigDecimal total;

    public Venta(Integer id, LocalDateTime fecha, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
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
    public void setId(Integer id) {
        this.id = id;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
    
}
