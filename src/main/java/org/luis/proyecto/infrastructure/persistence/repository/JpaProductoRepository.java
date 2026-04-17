package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    Optional<ProductoEntity> findByCodigo(String codigo);
}
