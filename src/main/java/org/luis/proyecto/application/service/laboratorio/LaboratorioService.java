package org.luis.proyecto.application.service.laboratorio;

import org.luis.proyecto.domain.model.Laboratorio;
import java.util.List;
import java.util.Optional;

public interface LaboratorioService {
    Laboratorio crear(Laboratorio laboratorio);
    Laboratorio actualizar(Integer id, Laboratorio laboratorio);
    void eliminar(Integer id);
    Optional<Laboratorio> obtenerPorId(Integer id);
    List<Laboratorio> listar();
}

