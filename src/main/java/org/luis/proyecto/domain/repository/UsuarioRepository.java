package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Integer id);
    Optional<Usuario> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    void deleteById(Integer id);
    List<Usuario> findAll();
}
