package org.luis.proyecto.domain.model;

public class Usuario {
    private Integer id;
    private String nombre;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contrasenia = contraseña;
    }

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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
