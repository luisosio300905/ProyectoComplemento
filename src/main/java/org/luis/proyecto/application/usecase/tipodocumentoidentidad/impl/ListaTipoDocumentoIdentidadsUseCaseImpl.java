package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.ListaTipoDocumentoIdentidadsUseCase;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

import java.util.List;

public class ListaTipoDocumentoIdentidadsUseCaseImpl implements ListaTipoDocumentoIdentidadsUseCase {
    private TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository;

    public ListaTipoDocumentoIdentidadsUseCaseImpl(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        this.tipodocumentoidentidadRepository = tipodocumentoidentidadRepository;
    }
    @Override
    public List<TipoDocumentoIdentidad> obtenerTodos() {
        return tipodocumentoidentidadRepository.findAll();
    }
}
