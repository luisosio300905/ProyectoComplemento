package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.EliminarTipoDocumentoIdentidadUseCase;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

public class EliminarTipoDocumentoIdentidadUseCaseImpl implements EliminarTipoDocumentoIdentidadUseCase {
    private final TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository;

    public EliminarTipoDocumentoIdentidadUseCaseImpl(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        this.tipodocumentoidentidadRepository = tipodocumentoidentidadRepository;
    }

    @Override
    public void eliminar(Integer id) {
        tipodocumentoidentidadRepository.deleteById(id);
    }
}
