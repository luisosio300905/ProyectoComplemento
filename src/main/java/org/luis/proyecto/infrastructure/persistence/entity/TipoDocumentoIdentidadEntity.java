package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipodocumentoidentidads")
public class TipoDocumentoIdentidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipodocumentoidentidad")
    private Integer id;
    @Column(nullable = false)
    private String nombre;

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
}
