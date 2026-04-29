package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.TipoDocumentoIdentidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTipoDocumentoIdentidadRepository extends JpaRepository<TipoDocumentoIdentidadEntity, Integer> {
    Optional<TipoDocumentoIdentidadEntity> findByNombre(String nombre);
}
