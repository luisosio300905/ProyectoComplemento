package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.CrearTipoDocumentoIdentidadUseCase;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

public class CrearTipoDocumentoIdentidadUseCaseImpl implements CrearTipoDocumentoIdentidadUseCase {
    private final TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository;

    public CrearTipoDocumentoIdentidadUseCaseImpl(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        this.tipodocumentoidentidadRepository = tipodocumentoidentidadRepository;
    }

    @Override
    public TipoDocumentoIdentidad crear(TipoDocumentoIdentidad tipodocumentoidentidad) {
        return tipodocumentoidentidadRepository.save(tipodocumentoidentidad);
    }
}
