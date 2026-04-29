package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepository {
    private final JpaUsuarioRepository jpaUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryAdapter(JpaUsuarioRepository jpaUsuarioRepository, UsuarioMapper usuarioMapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioMapper
                .toUsuario(jpaUsuarioRepository.save(usuarioMapper.toUsuarioEntity(usuario)));
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return jpaUsuarioRepository
                .findById(id).map(usuarioMapper::toUsuario);
    }

    @Override
    public Optional<Usuario> findByNombre(String nombre) {
        return jpaUsuarioRepository
                .findByNombre(nombre)
                .map(usuarioMapper::toUsuario);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return jpaUsuarioRepository.existsByNombre(nombre);
    }

    @Override
    public void deleteById(Integer id) {
        jpaUsuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioMapper.toUsuarioList(jpaUsuarioRepository.findAll());
    }
}

