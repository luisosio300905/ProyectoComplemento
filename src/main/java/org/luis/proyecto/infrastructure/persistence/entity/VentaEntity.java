package org.luis.proyecto.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = false)
    private BigDecimal total;


    public VentaEntity(Integer id, LocalDateTime fecha, BigDecimal total) {
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
