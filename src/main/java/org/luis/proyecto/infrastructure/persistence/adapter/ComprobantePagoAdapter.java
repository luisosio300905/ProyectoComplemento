package org.luis.proyecto.infrastructure.persistence.adapter;
import org.luis.proyecto.application.port.ComprobantePagoPort;
import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.infrastructure.mapper.ComprobantePagoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaComprobantePagoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ComprobantePagoAdapter implements ComprobantePagoPort {
    private final JpaComprobantePagoRepository repository;
    private final ComprobantePagoMapper mapper;

    public ComprobantePagoAdapter(JpaComprobantePagoRepository repository, ComprobantePagoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ComprobantePago save(ComprobantePago obj) {
        return mapper.toDomain(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public Optional<ComprobantePago> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<ComprobantePago> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
