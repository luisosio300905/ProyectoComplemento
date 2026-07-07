package org.luis.proyecto.application.service.subcuenta;

import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;

import java.util.List;

public interface SubCuentaService {
    SubCuenta crear(SubCuenta subCuenta);
    SubCuenta actualizar(SubCuentaPK id, SubCuenta subCuenta);
    void eliminar(SubCuentaPK id);
    SubCuenta obtenerById(SubCuentaPK id);
    List<SubCuenta> obtenerTodos();
    List<SubCuenta> obtenerPorCuentaId(String cuentaId);
    void eliminarPorCuentaId(String cuentaId);
}

