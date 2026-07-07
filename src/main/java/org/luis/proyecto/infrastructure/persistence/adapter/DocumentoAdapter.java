package org.luis.proyecto.infrastructure.persistence.adapter;
import org.luis.proyecto.application.port.DocumentoPort;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.infrastructure.mapper.DocumentoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDocumentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DocumentoAdapter implements DocumentoPort {
    private final JpaDocumentoRepository repository;
    private final DocumentoMapper mapper;

    public DocumentoAdapter(JpaDocumentoRepository repository, DocumentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Documento save(Documento obj) {
        return mapper.toDomain(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public Optional<Documento> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Documento> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
