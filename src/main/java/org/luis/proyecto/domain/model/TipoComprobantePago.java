package org.luis.proyecto.domain.model;

public class TipoComprobantePago {
    private Integer id;
    private String tipoComprobante;

    public TipoComprobantePago(Integer id, String tipoComprobante) {
        this.id = id;
        this.tipoComprobante = tipoComprobante;
    }

    public TipoComprobantePago(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
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