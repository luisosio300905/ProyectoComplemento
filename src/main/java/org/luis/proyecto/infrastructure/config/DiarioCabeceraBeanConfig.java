package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.diariocabecera.DiarioCabeceraService;
import org.luis.proyecto.application.service.diariocabecera.impl.DiarioCabeceraServiceImpl;
import org.luis.proyecto.application.usecase.diariocabecera.*;
import org.luis.proyecto.application.usecase.diariocabecera.impl.*;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiarioCabeceraBeanConfig {

    @Bean
    public CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new CrearDiarioCabeceraUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public ActualizarDiarioCabeceraUseCase actualizarDiarioCabeceraUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new ActualizarDiarioCabeceraUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public EliminarDiarioCabeceraUseCase eliminarDiarioCabeceraUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new EliminarDiarioCabeceraUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public ListaDiarioCabeceraUseCase listaDiarioCabeceraUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new ListaDiarioCabeceraUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public ObtenerDiarioCabeceraUseCase obtenerDiarioCabeceraUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new ObtenerDiarioCabeceraUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public DiarioCabeceraService diarioCabeceraService(
            CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase,
            ActualizarDiarioCabeceraUseCase actualizarDiarioCabeceraUseCase,
            EliminarDiarioCabeceraUseCase eliminarDiarioCabeceraUseCase,
            ListaDiarioCabeceraUseCase listaDiarioCabeceraUseCase,
            ObtenerDiarioCabeceraUseCase obtenerDiarioCabeceraUseCase) {
        return new DiarioCabeceraServiceImpl(
                crearDiarioCabeceraUseCase,
                actualizarDiarioCabeceraUseCase,
                eliminarDiarioCabeceraUseCase,
                listaDiarioCabeceraUseCase,
                obtenerDiarioCabeceraUseCase
        );
    }
}

