package org.luis.proyecto.application.service.moneda;

import org.luis.proyecto.domain.model.Moneda;
import java.util.List;
import java.util.Optional;

public interface MonedaService {
    Moneda crear(Moneda moneda);
    Moneda actualizar(Integer id, Moneda moneda);
    void eliminar(Integer id);
    Optional<Moneda> obtenerPorId(Integer id);
    List<Moneda> listar();
}

