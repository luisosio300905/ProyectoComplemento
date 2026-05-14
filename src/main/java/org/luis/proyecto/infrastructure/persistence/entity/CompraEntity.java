package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_comprobante_pago")
    private ComprobantePagoEntity comprobantePago;

    public CompraEntity() {
    }

    public CompraEntity(Integer id, LocalDateTime fecha, BigDecimal total, ProveedorEntity proveedor, ComprobantePagoEntity comprobantePago) {
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

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ComprobantePagoEntity getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(ComprobantePagoEntity comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
}

