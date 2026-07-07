package org.luis.proyecto.application.usecase.diariocabecera;

import org.luis.proyecto.domain.model.DiarioCabecera;

public interface ObtenerDiarioCabeceraUseCase {
    DiarioCabecera obtenerById(Long id);
    DiarioCabecera obtenerByEmpresaId(String empresaId);
}

