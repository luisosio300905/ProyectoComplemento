package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private String razonSocial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoIdentidadEntity tipoDocumentoIdentidad;

    private String numeroDocumento;
    private String direccion;
    private String celular;
    private String correo;
    private LocalDateTime fechaIngreso;
    private String estado;
    private LocalDateTime ultimoComprobante;

    public ProveedorEntity() {
    }

    public ProveedorEntity(Integer id, String nombre, String descripcion, String razonSocial,
                          TipoDocumentoIdentidadEntity tipoDocumentoIdentidad, String numeroDocumento,
                          String direccion, String celular, String correo, LocalDateTime fechaIngreso,
                          String estado, LocalDateTime ultimoComprobante) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.razonSocial = razonSocial;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.ultimoComprobante = ultimoComprobante;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public TipoDocumentoIdentidadEntity getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(TipoDocumentoIdentidadEntity tipoDocumentoIdentidad) {
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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getUltimoComprobante() {
        return ultimoComprobante;
    }

    public void setUltimoComprobante(LocalDateTime ultimoComprobante) {
        this.ultimoComprobante = ultimoComprobante;
    }
}

