package org.luis.proyecto.domain.model;

import java.math.BigDecimal;

public class ComprobantePago {
    private Integer id;
    private Cliente cliente;
    private BigDecimal total;
    private TipoComprobantePago tipoComprobantePago;
    private String descripcion;

    public ComprobantePago(Integer id, Cliente cliente, BigDecimal total, TipoComprobantePago tipoComprobantePago, String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.tipoComprobantePago = tipoComprobantePago;
        this.descripcion = descripcion;
    }

    public ComprobantePago(Cliente cliente, BigDecimal total, TipoComprobantePago tipoComprobantePago, String descripcion) {
        this.cliente = cliente;
        this.total = total;
        this.tipoComprobantePago = tipoComprobantePago;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public TipoComprobantePago getTipoComprobantePago() {
        return tipoComprobantePago;
    }

    public void setTipoComprobantePago(TipoComprobantePago tipoComprobantePago) {
        this.tipoComprobantePago = tipoComprobantePago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


