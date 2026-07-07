package org.luis.proyecto.application.service.cuenta;

import org.luis.proyecto.domain.model.Cuenta;
import java.util.List;

public interface CuentaService {
    Cuenta crear(Cuenta cuenta);
    Cuenta actualizar(String id, Cuenta cuenta);
    void eliminar(String id);
    Cuenta obtenerById(String id);
    List<Cuenta> obtenerTodos();
}

