package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.domain.repository.SubDivisionariaRepository;
import org.luis.proyecto.infrastructure.mapper.SubDivisionariaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;
import org.luis.proyecto.infrastructure.persistence.repository.JpaSubDivisionariaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubDivisionariaRepositoryAdapter implements SubDivisionariaRepository {
    private final JpaSubDivisionariaRepository jpaSubDivisionariaRepository;
    private final SubDivisionariaMapper subDivisionariaMapper;

    public SubDivisionariaRepositoryAdapter(JpaSubDivisionariaRepository jpaSubDivisionariaRepository, SubDivisionariaMapper subDivisionariaMapper) {
        this.jpaSubDivisionariaRepository = jpaSubDivisionariaRepository;
        this.subDivisionariaMapper = subDivisionariaMapper;
    }

    @Override
    public SubDivisionaria save(SubDivisionaria subDivisionaria) {
        return subDivisionariaMapper.toSubDivisionaria(jpaSubDivisionariaRepository.save(subDivisionariaMapper.toSubDivisionariaEntity(subDivisionaria)));
    }

    @Override
    public Optional<SubDivisionaria> findById(SubDivisionariaPK id) {
        return jpaSubDivisionariaRepository.findById(id).map(subDivisionariaMapper::toSubDivisionaria);
    }

    @Override
    public void deleteById(SubDivisionariaPK id) {
        jpaSubDivisionariaRepository.deleteById(id);
    }

    @Override
    public List<SubDivisionaria> findAll() {
        return subDivisionariaMapper.toSubDivisionariaList(jpaSubDivisionariaRepository.findAll());
    }

    @Override
    public List<SubDivisionaria> findByDivisionariaId(String cuentaId, String subCtaId, String divisioId) {
        return subDivisionariaMapper.toSubDivisionariaList(jpaSubDivisionariaRepository.findByDivisioIdAndSubCtaIdAndCuentaId(divisioId, subCtaId, cuentaId));
    }

    @Override
    public void deleteByDivisionariaId(String cuentaId, String subCtaId, String divisioId) {
        jpaSubDivisionariaRepository.deleteByDivisioIdAndSubCtaIdAndCuentaId(divisioId, subCtaId, cuentaId);
    }
}

