package org.luis.proyecto.application.usecase.laboratorio;

import org.luis.proyecto.domain.model.Laboratorio;

public interface ActualizarLaboratorioUseCase {
    Laboratorio actualizar(Integer id, Laboratorio laboratorio);
}
