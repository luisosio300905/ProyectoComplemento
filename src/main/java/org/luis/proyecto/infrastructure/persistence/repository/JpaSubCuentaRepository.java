package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaEntity;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSubCuentaRepository extends JpaRepository<SubCuentaEntity, SubCuentaPK> {
    List<SubCuentaEntity> findByCuentaId(String cuentaId);
    void deleteByCuentaId(String cuentaId);
}

