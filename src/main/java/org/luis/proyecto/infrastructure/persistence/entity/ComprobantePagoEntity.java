package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.model.TipoComprobantePago;

import java.math.BigDecimal;

@Entity
@Table(name = "comprobantes_pago")
public class ComprobantePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Cliente cliente;
    private BigDecimal total;
    private TipoComprobantePago tipoComprobantePago;
    private String descripcion;
}
