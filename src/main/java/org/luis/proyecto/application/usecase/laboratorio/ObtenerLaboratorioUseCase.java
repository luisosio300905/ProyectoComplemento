package org.luis.proyecto.application.usecase.laboratorio;

import org.luis.proyecto.domain.model.Laboratorio;
import java.util.Optional;

public interface ObtenerLaboratorioUseCase {
    Optional<Laboratorio> obtenerPorId(Integer id);
}
