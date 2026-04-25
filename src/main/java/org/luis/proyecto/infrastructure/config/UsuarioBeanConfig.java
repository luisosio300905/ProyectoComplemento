package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.application.service.usuario.impl.UsuarioServiceImpl;
import org.luis.proyecto.application.usecase.usuario.*;
import org.luis.proyecto.application.usecase.usuario.impl.*;
import org.luis.proyecto.domain.repository.UsuarioRepository;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioBeanConfig {

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new CrearUsuarioUseCaseImpl(usuarioRepository);
    }

    @Bean
    public ActualizarUsuarioUseCase actualizarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new ActualizarUsuarioUseCaseImpl(usuarioRepository);
    }

    @Bean
    public EliminarUsuarioUseCase eliminarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new EliminarUsuarioUseCaseImpl(usuarioRepository);
    }

    @Bean
    public ListaUsuariosUseCase listaUsuariosUseCase(UsuarioRepository usuarioRepository) {
        return new ListaUsuariosUseCaseImpl(usuarioRepository);
    }

    @Bean
    public ObtenerUsuarioUseCase obtenerUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new ObtenerUsuarioUseCaseImpl(usuarioRepository);
    }

    @Bean
    public UsuarioService usuarioService(
            CrearUsuarioUseCase crearUsuarioUseCase,
            ActualizarUsuarioUseCase actualizarUsuarioUseCase,
            EliminarUsuarioUseCase eliminarUsuarioUseCase,
            ListaUsuariosUseCase listaUsuariosUseCase,
            ObtenerUsuarioUseCase obtenerUsuarioUseCase,
            UsuarioMapper usuarioMapper) {
        return new UsuarioServiceImpl(
                crearUsuarioUseCase,
                actualizarUsuarioUseCase,
                eliminarUsuarioUseCase,
                listaUsuariosUseCase,
                obtenerUsuarioUseCase,
                usuarioMapper
        );
    }
}

