package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.ObtenerTipoDocumentoIdentidadUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

public class ObtenerTipoDocumentoIdentidadUseCaseImpl implements ObtenerTipoDocumentoIdentidadUseCase {
    private final TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository;

    public ObtenerTipoDocumentoIdentidadUseCaseImpl(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        this.tipodocumentoidentidadRepository = tipodocumentoidentidadRepository;
    }

    @Override
    public TipoDocumentoIdentidad obtenerTipoDocumentoIdentidad(Integer id) {
        return tipodocumentoidentidadRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de documento de identidad no encontrado"));
    }

}
