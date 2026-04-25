package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private String contrasenia;

    public UsuarioEntity(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
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
