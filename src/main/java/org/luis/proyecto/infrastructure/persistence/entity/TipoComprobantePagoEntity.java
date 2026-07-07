package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipos_comprobante")
public class TipoComprobantePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_comprobante")
    private Integer id;

    private String tipoComprobante;

    public TipoComprobantePagoEntity(Integer id, String tipoComprobante, List<ComprobantePagoEntity> comprobantesPago) {
        this.id = id;
        this.tipoComprobante = tipoComprobante;
    }

    public TipoComprobantePagoEntity(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public TipoComprobantePagoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

}
