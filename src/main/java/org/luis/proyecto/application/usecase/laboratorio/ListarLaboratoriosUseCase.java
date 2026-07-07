package org.luis.proyecto.application.usecase.laboratorio;

import org.luis.proyecto.domain.model.Laboratorio;
import java.util.List;

public interface ListarLaboratoriosUseCase {
    List<Laboratorio> listar();
}
