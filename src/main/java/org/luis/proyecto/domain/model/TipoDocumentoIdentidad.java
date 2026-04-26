package org.luis.proyecto.domain.model;

public class TipoDocumentoIdentidad {
    private Integer id;
    private String nombre;

    public TipoDocumentoIdentidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoDocumentoIdentidad(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
