package org.luis.proyecto.application.service.cuenta;

import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.infrastructure.rest.response.CuentaJerarquiaResponse;
import java.util.List;

public interface CuentaService {
    Cuenta crear(Cuenta cuenta);
    Cuenta actualizar(String id, Cuenta cuenta);
    void eliminar(String id);
    Cuenta obtenerById(String id);
    List<Cuenta> obtenerTodos();
    List<CuentaJerarquiaResponse> obtenerJerarquia();
}


