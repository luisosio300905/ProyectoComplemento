package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipos_documento")
public class TipoDocumentoIdentidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @OneToMany(mappedBy = "tipoDocumentoIdentidad")
    private List<ClienteEntity> clientes;
    @OneToMany(mappedBy = "tipoDocumentoIdentidad")
    private List<ProveedorEntity> proveedores;

    public TipoDocumentoIdentidadEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoDocumentoIdentidadEntity() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }

    public List<ProveedorEntity> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<ProveedorEntity> proveedores) {
        this.proveedores = proveedores;
    }
}
