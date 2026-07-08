package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.SaldoCuenta;

import java.util.List;
import java.util.Optional;

public interface DiarioDetalleRepository {
    DiarioDetalle save(DiarioDetalle diarioDetalle);
    Optional<DiarioDetalle> findById(Integer id);
    void deleteById(Integer id);
    List<DiarioDetalle> findAll();
    List<DiarioDetalle> findByDiaCabCompId(Long diaCabCompId);
    void deleteByDiaCabCompId(Long diaCabCompId);

    /**
     * Suma el debe y el haber de todos los detalles agrupados por cuenta contable
     * (Cuenta / SubCuenta / Divisionaria / SubDivisionaria), opcionalmente filtrando
     * por empresa y periodo (año/mes). Los parámetros nulos no filtran.
     * Es la base para construir el Balance General en cualquier momento.
     */
    List<SaldoCuenta> obtenerSaldos(String empresaId, Integer ano, Integer mes);
}

