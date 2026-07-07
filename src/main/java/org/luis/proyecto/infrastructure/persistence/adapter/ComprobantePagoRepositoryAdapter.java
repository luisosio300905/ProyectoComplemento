package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;
import org.luis.proyecto.infrastructure.mapper.ComprobantePagoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaComprobantePagoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ComprobantePagoRepositoryAdapter implements ComprobantePagoRepository {
    private final JpaComprobantePagoRepository jpaComprobantePagoRepository;
    private final ComprobantePagoMapper comprobantePagoMapper;

    public ComprobantePagoRepositoryAdapter(JpaComprobantePagoRepository jpaComprobantePagoRepository, ComprobantePagoMapper comprobantePagoMapper) {
        this.jpaComprobantePagoRepository = jpaComprobantePagoRepository;
        this.comprobantePagoMapper = comprobantePagoMapper;
    }


    @Override
    public ComprobantePago save(ComprobantePago comprobantePago) {
        return comprobantePagoMapper.toDomain(jpaComprobantePagoRepository.save(comprobantePagoMapper.toEntity(comprobantePago)));
    }

    @Override
    public void deleteById(String id) {
        jpaComprobantePagoRepository.deleteById(id);
    }

    @Override
    public Optional<ComprobantePago> findById(String id) {
        return jpaComprobantePagoRepository.findById(id).map(comprobantePagoMapper::toDomain);
    }

    @Override
    public List<ComprobantePago> findAll() {
        return jpaComprobantePagoRepository.findAll().stream()
               .map(comprobantePagoMapper::toDomain)
               .toList();
    }
}
