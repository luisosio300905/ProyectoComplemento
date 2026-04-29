package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.detalleventa.DetalleVentaService;
import org.luis.proyecto.application.service.detalleventa.impl.DetalleVentaServiceImpl;
import org.luis.proyecto.application.usecase.detalleventa.*;
import org.luis.proyecto.application.usecase.detalleventa.impl.*;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetalleVentaBeanConfig {

    @Bean
    public CrearDetalleVentaUseCase crearDetalleVentaUseCase(DetalleVentaRepository detalleVentaRepository) {
        return new CrearDetalleVentaUseCaseImpl(detalleVentaRepository);
    }

    @Bean
    public ActualizarDetalleVentaUseCase actualizarDetalleVentaUseCase(DetalleVentaRepository detalleVentaRepository) {
        return new ActualizarDetalleVentaUseCaseImpl(detalleVentaRepository);
    }

    @Bean
    public EliminarDetalleVentaUseCase eliminarDetalleVentaUseCase(DetalleVentaRepository detalleVentaRepository) {
        return new EliminarDetalleVentaUseCaseImpl(detalleVentaRepository);
    }

    @Bean
    public ObtenerDetalleVentaUseCase obtenerDetalleVentaUseCase(DetalleVentaRepository detalleVentaRepository) {
        return new ObtenerDetalleVentaUseCaseImpl(detalleVentaRepository);
    }

    @Bean
    public ListaDetalleVentaUseCase listaDetalleVentaUseCase(DetalleVentaRepository detalleVentaRepository) {
        return new ListaDetalleVentaUseCaseImpl(detalleVentaRepository);
    }

    @Bean
    public DetalleVentaService detalleVentaService(
            ActualizarDetalleVentaUseCase actualizarDetalleVentaUseCase,
            CrearDetalleVentaUseCase crearDetalleVentaUseCase,
            EliminarDetalleVentaUseCase eliminarDetalleVentaUseCase,
            ListaDetalleVentaUseCase listaDetalleVentaUseCase,
            ObtenerDetalleVentaUseCase obtenerDetalleVentaUseCase
    ){
        return new DetalleVentaServiceImpl(
                actualizarDetalleVentaUseCase,
                crearDetalleVentaUseCase,
                eliminarDetalleVentaUseCase,
                listaDetalleVentaUseCase,
                obtenerDetalleVentaUseCase
        );
    }
}