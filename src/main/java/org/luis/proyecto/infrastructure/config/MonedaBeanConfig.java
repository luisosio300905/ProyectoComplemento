package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.moneda.MonedaService;
import org.luis.proyecto.application.service.moneda.impl.MonedaServiceImpl;
import org.luis.proyecto.application.usecase.moneda.*;
import org.luis.proyecto.application.usecase.moneda.impl.*;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonedaBeanConfig {
    @Bean
    public CrearMonedaUseCase crearMonedaUseCase(MonedaRepository monedaRepository) {
        return new CrearMonedaUseCaseImpl(monedaRepository);
    }

    @Bean
    public ActualizarMonedaUseCase actualizarMonedaUseCase(MonedaRepository monedaRepository) {
        return new ActualizarMonedaUseCaseImpl(monedaRepository);
    }

    @Bean
    public EliminarMonedaUseCase eliminarMonedaUseCase(MonedaRepository monedaRepository) {
        return new EliminarMonedaUseCaseImpl(monedaRepository);
    }

    @Bean
    public ListarMonedasUseCase listarMonedasUseCase(MonedaRepository monedaRepository) {
        return new ListarMonedasUseCaseImpl(monedaRepository);
    }

    @Bean
    public ObtenerMonedaUseCase obtenerMonedaUseCase(MonedaRepository monedaRepository) {
        return new ObtenerMonedaUseCaseImpl(monedaRepository);
    }

    @Bean
    public MonedaService monedaService(
            CrearMonedaUseCase crearMonedaUseCase,
            ActualizarMonedaUseCase actualizarMonedaUseCase,
            EliminarMonedaUseCase eliminarMonedaUseCase,
            ListarMonedasUseCase listarMonedasUseCase,
            ObtenerMonedaUseCase obtenerMonedaUseCase
    ) {
        return new MonedaServiceImpl(
                crearMonedaUseCase,
                actualizarMonedaUseCase,
                eliminarMonedaUseCase,
                obtenerMonedaUseCase,
                listarMonedasUseCase
        );
    }
}

