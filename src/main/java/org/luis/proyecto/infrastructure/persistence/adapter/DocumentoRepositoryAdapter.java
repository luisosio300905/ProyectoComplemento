package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.domain.repository.DocumentoRepository;
import org.luis.proyecto.infrastructure.mapper.DocumentoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDocumentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentoRepositoryAdapter implements DocumentoRepository {
    private final JpaDocumentoRepository jpaDocumentoRepository;
    private final DocumentoMapper documentoMapper;

    public DocumentoRepositoryAdapter(JpaDocumentoRepository jpaDocumentoRepository, DocumentoMapper documentoMapper) {
        this.jpaDocumentoRepository = jpaDocumentoRepository;
        this.documentoMapper = documentoMapper;
    }

    @Override
    public Documento save(Documento documento) {
        return documentoMapper.toDomain(jpaDocumentoRepository.save(documentoMapper.toEntity(documento)));
    }

    @Override
    public void deleteById(String id) {
        jpaDocumentoRepository.deleteById(id);
    }

    @Override
    public Optional<Documento> findById(String id) {
        return jpaDocumentoRepository.findById(id).map(documentoMapper::toDomain);
    }

    @Override
    public List<Documento> findAll() {
        return jpaDocumentoRepository.findAll().stream()
               .map(documentoMapper::toDomain)
               .toList();
    }
}

