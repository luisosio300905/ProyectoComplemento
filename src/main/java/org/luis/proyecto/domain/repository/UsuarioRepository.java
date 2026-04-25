package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Usuario;

public interface UsuarioRepository {
    Usuario findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
