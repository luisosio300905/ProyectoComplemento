package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.EliminarTipoDocumentoIdentidadUseCase;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

public class EliminarTipoDocumentoIdentidadUseCaseImpl implements EliminarTipoDocumentoIdentidadUseCase {
    private final TipoDocumentoIdentidadRepository tipoDocumentoIdentidadRepository;

    public EliminarTipoDocumentoIdentidadUseCaseImpl(TipoDocumentoIdentidadRepository tipoDocumentoIdentidadRepository) {
        this.tipoDocumentoIdentidadRepository = tipoDocumentoIdentidadRepository;
    }

    @Override
    public void eliminar(Integer id) {
        tipoDocumentoIdentidadRepository.deleteById(id);
    }
}