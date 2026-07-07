package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.DiarioCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDiarioCabeceraRepository extends JpaRepository<DiarioCabeceraEntity, Long> {
    List<DiarioCabeceraEntity> findByEmpresaId(String empresaId);
    List<DiarioCabeceraEntity> findByDiaCabAnoAndDiaCabMes(Integer diaCabAno, Integer diaCabMes);
}

