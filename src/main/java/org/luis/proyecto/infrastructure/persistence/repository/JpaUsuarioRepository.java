package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
