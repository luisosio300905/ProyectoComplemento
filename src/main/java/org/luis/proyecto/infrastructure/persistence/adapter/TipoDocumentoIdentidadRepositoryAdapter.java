package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;
import org.luis.proyecto.infrastructure.mapper.TipoDocumentoIdentidadMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoDocumentoIdentidadRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoDocumentoIdentidadRepositoryAdapter implements TipoDocumentoIdentidadRepository {

    private final JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository;
    private final TipoDocumentoIdentidadMapper tipodocumentoidentidadMapper;

    public TipoDocumentoIdentidadRepositoryAdapter(JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository, TipoDocumentoIdentidadMapper tipodocumentoidentidadMapper) {
        this.jpaTipoDocumentoIdentidadRepository = jpaTipoDocumentoIdentidadRepository;
        this.tipodocumentoidentidadMapper = tipodocumentoidentidadMapper;
    }

    @Override
    public TipoDocumentoIdentidad save(TipoDocumentoIdentidad tipodocumentoidentidad) {
        return tipodocumentoidentidadMapper
                .toTipoDocumentoIdentidad(jpaTipoDocumentoIdentidadRepository.save(tipodocumentoidentidadMapper.toTipoDocumentoIdentidadEntity(tipodocumentoidentidad)));
    }

    @Override
    public Optional<TipoDocumentoIdentidad> findById(Integer id) {
        return jpaTipoDocumentoIdentidadRepository
                .findById(id).map(p -> tipodocumentoidentidadMapper.toTipoDocumentoIdentidad(p));
    }

    @Override
    public Optional<TipoDocumentoIdentidad> findByNombre(String nombre) {
        return jpaTipoDocumentoIdentidadRepository
                .findByNombre(nombre)
                .map(p -> tipodocumentoidentidadMapper.toTipoDocumentoIdentidad(p));
    }

    @Override
    public void deleteById(Integer id) {
        jpaTipoDocumentoIdentidadRepository.deleteById(id);
    }

    @Override
    public List<TipoDocumentoIdentidad> findAll() {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadList(jpaTipoDocumentoIdentidadRepository.findAll());
    }


}
