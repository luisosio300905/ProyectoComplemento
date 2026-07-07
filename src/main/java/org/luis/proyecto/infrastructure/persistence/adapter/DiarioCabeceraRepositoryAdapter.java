package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.luis.proyecto.infrastructure.mapper.DiarioCabeceraMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDiarioCabeceraRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DiarioCabeceraRepositoryAdapter implements DiarioCabeceraRepository {
    private final JpaDiarioCabeceraRepository jpaDiarioCabeceraRepository;
    private final DiarioCabeceraMapper diarioCabeceraMapper;

    public DiarioCabeceraRepositoryAdapter(JpaDiarioCabeceraRepository jpaDiarioCabeceraRepository, DiarioCabeceraMapper diarioCabeceraMapper) {
        this.jpaDiarioCabeceraRepository = jpaDiarioCabeceraRepository;
        this.diarioCabeceraMapper = diarioCabeceraMapper;
    }

    @Override
    public DiarioCabecera save(DiarioCabecera diarioCabecera) {
        return diarioCabeceraMapper
                .toDiarioCabecera(jpaDiarioCabeceraRepository.save(diarioCabeceraMapper.toDiarioCabeceraEntity(diarioCabecera)));
    }

    @Override
    public Optional<DiarioCabecera> findById(Long id) {
        return jpaDiarioCabeceraRepository
                .findById(id).map(diarioCabeceraMapper::toDiarioCabecera);
    }

    @Override
    public void deleteById(Long id) {
        jpaDiarioCabeceraRepository.deleteById(id);
    }

    @Override
    public List<DiarioCabecera> findAll() {
        return diarioCabeceraMapper.toDiarioCabeceraList(jpaDiarioCabeceraRepository.findAll());
    }

    @Override
    public List<DiarioCabecera> findByEmpresaId(String empresaId) {
        return diarioCabeceraMapper.toDiarioCabeceraList(jpaDiarioCabeceraRepository.findByEmpresaId(empresaId));
    }

    @Override
    public List<DiarioCabecera> findByDiaCabAnoAndDiaCabMes(Integer ano, Integer mes) {
        return diarioCabeceraMapper.toDiarioCabeceraList(jpaDiarioCabeceraRepository.findByDiaCabAnoAndDiaCabMes(ano, mes));
    }
}

