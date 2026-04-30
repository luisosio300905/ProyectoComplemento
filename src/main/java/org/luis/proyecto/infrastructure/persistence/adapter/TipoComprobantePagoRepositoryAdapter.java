package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;
import org.luis.proyecto.infrastructure.mapper.TipoComprobantePagoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoComprobantePagoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoComprobantePagoRepositoryAdapter implements TipoComprobantePagoRepository {
    private final JpaTipoComprobantePagoRepository jpaTipoComprobantePagoRepository;
    private final TipoComprobantePagoMapper tipoComprobantePagoMapper;

    public TipoComprobantePagoRepositoryAdapter(JpaTipoComprobantePagoRepository jpaTipoComprobantePagoRepository,
                                                TipoComprobantePagoMapper tipoComprobantePagoMapper) {
        this.jpaTipoComprobantePagoRepository = jpaTipoComprobantePagoRepository;
        this.tipoComprobantePagoMapper = tipoComprobantePagoMapper;
    }

    @Override
    public TipoComprobantePago save(TipoComprobantePago tipoComprobantePago) {
        return tipoComprobantePagoMapper
                .toTipoComprobantePago(jpaTipoComprobantePagoRepository
                        .save(tipoComprobantePagoMapper.toTipoComprobantePagoEntity(tipoComprobantePago)));
    }

    @Override
    public Optional<TipoComprobantePago> findById(Integer id) {
        return jpaTipoComprobantePagoRepository
                .findById(id)
                .map(e -> tipoComprobantePagoMapper.toTipoComprobantePago(e));
    }

    @Override
    public void deleteById(Integer id) {
        jpaTipoComprobantePagoRepository.deleteById(id);
    }

    @Override
    public List<TipoComprobantePago> findAll() {
        return tipoComprobantePagoMapper
                .toTipoComprobantePagoList(jpaTipoComprobantePagoRepository.findAll());
    }
}