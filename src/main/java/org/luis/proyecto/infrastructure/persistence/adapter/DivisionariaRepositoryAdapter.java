package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.domain.repository.DivisionariaRepository;
import org.luis.proyecto.infrastructure.mapper.DivisionariaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDivisionariaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DivisionariaRepositoryAdapter implements DivisionariaRepository {
    private final JpaDivisionariaRepository jpaDivisionariaRepository;
    private final DivisionariaMapper divisionariaMapper;

    public DivisionariaRepositoryAdapter(JpaDivisionariaRepository jpaDivisionariaRepository, DivisionariaMapper divisionariaMapper) {
        this.jpaDivisionariaRepository = jpaDivisionariaRepository;
        this.divisionariaMapper = divisionariaMapper;
    }

    @Override
    public Divisionaria save(Divisionaria divisionaria) {
        return divisionariaMapper.toDivisionaria(jpaDivisionariaRepository.save(divisionariaMapper.toDivisionariaEntity(divisionaria)));
    }

    @Override
    public Optional<Divisionaria> findById(DivisionariaPK id) {
        return jpaDivisionariaRepository.findById(id).map(divisionariaMapper::toDivisionaria);
    }

    @Override
    public void deleteById(DivisionariaPK id) {
        jpaDivisionariaRepository.deleteById(id);
    }

    @Override
    public List<Divisionaria> findAll() {
        return divisionariaMapper.toDivisionariaList(jpaDivisionariaRepository.findAll());
    }

    @Override
    public List<Divisionaria> findBySubCuentaId(String cuentaId, String subCtaId) {
        return divisionariaMapper.toDivisionariaList(jpaDivisionariaRepository.findBySubCtaIdAndCuentaId(subCtaId, cuentaId));
    }

    @Override
    public void deleteBySubCuentaId(String cuentaId, String subCtaId) {
        jpaDivisionariaRepository.deleteBySubCtaIdAndCuentaId(subCtaId, cuentaId);
    }
}

