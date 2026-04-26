package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipos_comprobante")
public class TipoComprobantePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoComprobante;
    @ManyToOne
    @JoinColumn(name = "id_comprobante_pago")
    private List<ComprobantePagoEntity> comprobantesPago;


}
