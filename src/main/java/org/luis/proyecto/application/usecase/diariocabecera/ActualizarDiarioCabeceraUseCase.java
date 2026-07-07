package org.luis.proyecto.application.usecase.diariocabecera;

import org.luis.proyecto.domain.model.DiarioCabecera;

public interface ActualizarDiarioCabeceraUseCase {
    DiarioCabecera actualizar(Long id, DiarioCabecera diarioCabecera);
}

