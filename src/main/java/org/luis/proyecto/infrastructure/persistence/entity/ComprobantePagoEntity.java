package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
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
}
