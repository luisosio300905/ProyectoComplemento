package org.luis.proyecto.domain.model;

import java.util.List;

public class Cliente {
    private Integer id;
    private String descripcion;
    private String razonSocial;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
    private String numeroDocumento;
    private String direccion;
    private String celular;
    private String correo;
    private List<ComprobantePago> comprobantes;

    public Cliente(Integer id,String descripcion, String razonSocial, String nombres, String apellidoPaterno, String apellidoMaterno, TipoDocumentoIdentidad tipoDocumentoIdentidad, String numeroDocumento, String direccion, String celular, String correo, List<ComprobantePago> comprobantes) {
        this.id = id;
        this.descripcion = descripcion;
        this.razonSocial = razonSocial;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.comprobantes = comprobantes;
    }

    public Cliente(String descripcion, String razonSocial, String nombres, String apellidoPaterno, String apellidoMaterno, TipoDocumentoIdentidad tipoDocumentoIdentidad, String numeroDocumento, String direccion, String celular, String correo, List<ComprobantePago> comprobantes) {
        this.descripcion = descripcion;
        this.razonSocial = razonSocial;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.comprobantes = comprobantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public TipoDocumentoIdentidad getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<ComprobantePago> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<ComprobantePago> comprobantes) {
        this.comprobantes = comprobantes;
    }
}
