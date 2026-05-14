package org.luis.proyecto.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

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
    
    @ManyToOne
    @JoinColumn(name = "id_comprobante_pago")
    private ComprobantePagoEntity comprobantePago;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVentaEntity> detallesVenta;
    public VentaEntity() {
    }

    public VentaEntity(Integer id, LocalDateTime fecha, BigDecimal total, ComprobantePagoEntity comprobantePago) {
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

    public ComprobantePagoEntity getComprobantePago() {
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

    public void setComprobantePago(ComprobantePagoEntity comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
}
