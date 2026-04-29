package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.model.TipoComprobantePago;

import java.math.BigDecimal;

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
    @JoinColumn(name = "id_tipo_comprobante_pago")
    private TipoComprobantePagoEntity tipoComprobantePago;
    private String descripcion;

    public ComprobantePagoEntity(Integer id, ClienteEntity cliente, BigDecimal total, TipoComprobantePagoEntity tipoComprobantePago, String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.tipoComprobantePago = tipoComprobantePago;
        this.descripcion = descripcion;
    }

    public ComprobantePagoEntity() {
    }

    public ComprobantePagoEntity(@NotNull @NotBlank Cliente cliente, @NotNull @NotBlank BigDecimal total, @NotNull @NotBlank TipoComprobantePago tipoComprobantePago, @NotNull @NotBlank String descripcion) {
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
}
