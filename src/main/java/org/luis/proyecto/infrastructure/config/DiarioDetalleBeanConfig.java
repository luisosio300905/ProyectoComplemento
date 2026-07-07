package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.diariodetalle.DiarioDetalleService;
import org.luis.proyecto.application.service.diariodetalle.impl.DiarioDetalleServiceImpl;
import org.luis.proyecto.application.usecase.diariodetalle.*;
import org.luis.proyecto.application.usecase.diariodetalle.impl.*;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiarioDetalleBeanConfig {

    @Bean
    public CrearDiarioDetalleUseCase crearDiarioDetalleUseCase(DiarioDetalleRepository diarioDetalleRepository) {
        return new CrearDiarioDetalleUseCaseImpl(diarioDetalleRepository);
    }

    @Bean
    public ActualizarDiarioDetalleUseCase actualizarDiarioDetalleUseCase(DiarioDetalleRepository diarioDetalleRepository) {
        return new ActualizarDiarioDetalleUseCaseImpl(diarioDetalleRepository);
    }

    @Bean
    public EliminarDiarioDetalleUseCase eliminarDiarioDetalleUseCase(DiarioDetalleRepository diarioDetalleRepository) {
        return new EliminarDiarioDetalleUseCaseImpl(diarioDetalleRepository);
    }

    @Bean
    public ListaDiarioDetalleUseCase listaDiarioDetalleUseCase(DiarioDetalleRepository diarioDetalleRepository) {
        return new ListaDiarioDetalleUseCaseImpl(diarioDetalleRepository);
    }

    @Bean
    public ObtenerDiarioDetalleUseCase obtenerDiarioDetalleUseCase(DiarioDetalleRepository diarioDetalleRepository) {
        return new ObtenerDiarioDetalleUseCaseImpl(diarioDetalleRepository);
    }

    @Bean
    public DiarioDetalleService diarioDetalleService(
            CrearDiarioDetalleUseCase crearDiarioDetalleUseCase,
            ActualizarDiarioDetalleUseCase actualizarDiarioDetalleUseCase,
            EliminarDiarioDetalleUseCase eliminarDiarioDetalleUseCase,
            ListaDiarioDetalleUseCase listaDiarioDetalleUseCase,
            ObtenerDiarioDetalleUseCase obtenerDiarioDetalleUseCase) {
        return new DiarioDetalleServiceImpl(
                crearDiarioDetalleUseCase,
                actualizarDiarioDetalleUseCase,
                eliminarDiarioDetalleUseCase,
                listaDiarioDetalleUseCase,
                obtenerDiarioDetalleUseCase
        );
    }
}

