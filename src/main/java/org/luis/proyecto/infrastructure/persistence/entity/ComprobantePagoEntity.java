package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "comprobantes_pago")
public class ComprobantePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante_pago")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobantePagoEntity tipoComprobantePago;
    private String descripcion;
    @OneToMany(mappedBy = "comprobantePago")
    private List<VentaEntity> ventas;

    public ComprobantePagoEntity(Integer id, ClienteEntity cliente, BigDecimal total, TipoComprobantePagoEntity tipoComprobantePago, String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.tipoComprobantePago = tipoComprobantePago;
        this.descripcion = descripcion;
    }

    public ComprobantePagoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public TipoComprobantePagoEntity getTipoComprobantePago() {
        return tipoComprobantePago;
    }

    public void setTipoComprobantePago(TipoComprobantePagoEntity tipoComprobantePago) {
        this.tipoComprobantePago = tipoComprobantePago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VentaEntity> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }
}
