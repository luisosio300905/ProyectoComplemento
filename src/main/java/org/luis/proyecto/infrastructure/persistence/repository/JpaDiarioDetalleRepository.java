package org.luis.proyecto.infrastructure.persistence.repository;

import org.luis.proyecto.infrastructure.persistence.entity.DiarioDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDiarioDetalleRepository extends JpaRepository<DiarioDetalleEntity, Integer> {
    List<DiarioDetalleEntity> findByDiaCabCompId(Long diaCabCompId);
    void deleteByDiaCabCompId(Long diaCabCompId);

    /**
     * Agrega debe y haber por cuenta contable uniéndose a la cabecera para poder
     * filtrar por empresa y periodo. Devuelve filas:
     * [cuentaId, subCtaId, divisioId, subDivId, sumDebe, sumHaber].
     */
    @Query("SELECT d.cuentaId, d.subCtaId, d.divisioId, d.subDivId, " +
           "SUM(d.diaDetDebe), SUM(d.diaDetHaber) " +
           "FROM DiarioDetalleEntity d JOIN d.diarioCabecera c " +
           "WHERE (:empresaId IS NULL OR c.empresaId = :empresaId) " +
           "AND (:ano IS NULL OR c.diaCabAno = :ano) " +
           "AND (:mes IS NULL OR c.diaCabMes = :mes) " +
           "GROUP BY d.cuentaId, d.subCtaId, d.divisioId, d.subDivId")
    List<Object[]> obtenerSaldos(@Param("empresaId") String empresaId,
                                 @Param("ano") Integer ano,
                                 @Param("mes") Integer mes);
}

