package org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.usecase.tipodocumentoidentidad.ActualizarTipoDocumentoIdentidadUseCase;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;

public class ActualizarTipoDocumentoIdentidadUseCaseImpl implements ActualizarTipoDocumentoIdentidadUseCase {
    private final TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository;

    public ActualizarTipoDocumentoIdentidadUseCaseImpl(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        this.tipodocumentoidentidadRepository = tipodocumentoidentidadRepository;
    }

    @Override
    public TipoDocumentoIdentidad actualizar(Integer id, TipoDocumentoIdentidad tipodocumentoidentidad) {
           TipoDocumentoIdentidad tipodocumentoidentidadActualizar = tipodocumentoidentidadRepository.findById(id).orElseThrow();
           actualizarTipoDocumentoIdentidad(tipodocumentoidentidadActualizar, tipodocumentoidentidad);
           return tipodocumentoidentidadRepository.save(tipodocumentoidentidadActualizar);
    }

    @Override
    public TipoDocumentoIdentidad actualizar(String nombre, TipoDocumentoIdentidad tipodocumentoidentidad) {
           TipoDocumentoIdentidad tipodocumentoidentidadActualizar = tipodocumentoidentidadRepository.findByNombre(nombre).orElseThrow();
           actualizarTipoDocumentoIdentidad(tipodocumentoidentidadActualizar, tipodocumentoidentidad);
        return tipodocumentoidentidadActualizar;
    }

    private void actualizarTipoDocumentoIdentidad(TipoDocumentoIdentidad tipodocumentoidentidad1, TipoDocumentoIdentidad tipodocumentoidentidad2) {
        tipodocumentoidentidad1.setNombre(tipodocumentoidentidad2.getNombre());
    }


}
