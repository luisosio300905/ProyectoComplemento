package org.luis.proyecto.infrastructure.persistence.repository;
import org.luis.proyecto.infrastructure.persistence.entity.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaDocumentoRepository extends JpaRepository<DocumentoEntity, String> {}
