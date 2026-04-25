package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
