package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.laboratorio.LaboratorioService;
import org.luis.proyecto.application.service.laboratorio.impl.LaboratorioServiceImpl;
import org.luis.proyecto.application.usecase.laboratorio.*;
import org.luis.proyecto.application.usecase.laboratorio.impl.*;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaboratorioBeanConfig {
    @Bean
    public CrearLaboratorioUseCase crearLaboratorioUseCase(LaboratorioRepository laboratorioRepository) {
        return new CrearLaboratorioUseCaseImpl(laboratorioRepository);
    }

    @Bean
    public ActualizarLaboratorioUseCase actualizarLaboratorioUseCase(LaboratorioRepository laboratorioRepository) {
        return new ActualizarLaboratorioUseCaseImpl(laboratorioRepository);
    }

    @Bean
    public EliminarLaboratorioUseCase eliminarLaboratorioUseCase(LaboratorioRepository laboratorioRepository) {
        return new EliminarLaboratorioUseCaseImpl(laboratorioRepository);
    }

    @Bean
    public ListarLaboratoriosUseCase listarLaboratoriosUseCase(LaboratorioRepository laboratorioRepository) {
        return new ListarLaboratoriosUseCaseImpl(laboratorioRepository);
    }

    @Bean
    public ObtenerLaboratorioUseCase obtenerLaboratorioUseCase(LaboratorioRepository laboratorioRepository) {
        return new ObtenerLaboratorioUseCaseImpl(laboratorioRepository);
    }

    @Bean
    public LaboratorioService laboratorioService(
            CrearLaboratorioUseCase crearLaboratorioUseCase,
            ActualizarLaboratorioUseCase actualizarLaboratorioUseCase,
            EliminarLaboratorioUseCase eliminarLaboratorioUseCase,
            ListarLaboratoriosUseCase listarLaboratoriosUseCase,
            ObtenerLaboratorioUseCase obtenerLaboratorioUseCase
    ) {
        return new LaboratorioServiceImpl(
                crearLaboratorioUseCase,
                actualizarLaboratorioUseCase,
                eliminarLaboratorioUseCase,
                obtenerLaboratorioUseCase,
                listarLaboratoriosUseCase
        );
    }
}

