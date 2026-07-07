package org.luis.proyecto.application.service.divisionaria;

import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;

import java.util.List;

public interface DivisionariaService {
    Divisionaria crear(Divisionaria divisionaria);
    Divisionaria actualizar(DivisionariaPK id, Divisionaria divisionaria);
    void eliminar(DivisionariaPK id);
    Divisionaria obtenerById(DivisionariaPK id);
    List<Divisionaria> obtenerTodos();
    List<Divisionaria> obtenerPorSubCuenta(String cuentaId, String subCtaId);
    void eliminarPorSubCuenta(String cuentaId, String subCtaId);
}

