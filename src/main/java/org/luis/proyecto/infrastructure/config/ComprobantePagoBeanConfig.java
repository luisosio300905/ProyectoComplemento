package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.comprobantepago.ComprobantePagoService;
import org.luis.proyecto.application.service.comprobantepago.impl.ComprobantePagoServiceImpl;
import org.luis.proyecto.application.usecase.comprobantepago.*;
import org.luis.proyecto.application.usecase.comprobantepago.impl.*;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComprobantePagoBeanConfig {

    @Bean
    public CrearComprobantePagoUseCase crearComprobantePagoUseCase(ComprobantePagoRepository comprobantePagoRepository) {
        return new CrearComprobantePagoUseCaseImpl(comprobantePagoRepository);
    }

    @Bean
    public ActualizarComprobantePagoUseCase actualizarComprobantePagoUseCase(ComprobantePagoRepository comprobantePagoRepository) {
        return new ActualizarComprobantePagoUseCaseImpl(comprobantePagoRepository);
    }

    @Bean
    public EliminarComprobantePagoUseCase eliminarComprobantePagoUseCase(ComprobantePagoRepository comprobantePagoRepository) {
        return new EliminarComprobantePagoUseCaseImpl(comprobantePagoRepository);
    }

    @Bean
    public ObtenerComprobantePagoUseCase obtenerComprobantePagoUseCase(ComprobantePagoRepository comprobantePagoRepository) {
        return new ObtenerComprobantePagoUseCaseImpl(comprobantePagoRepository);
    }

    @Bean
    public ListaComprobantePagoUseCase listaComprobantePagoUseCase(ComprobantePagoRepository comprobantePagoRepository) {
        return new ListaComprobantePagoUseCaseImpl(comprobantePagoRepository);
    }

    @Bean
    public ComprobantePagoService comprobantePagoService(
            CrearComprobantePagoUseCase crearComprobantePagoUseCase,
            ActualizarComprobantePagoUseCase actualizarComprobantePagoUseCase,
            EliminarComprobantePagoUseCase eliminarComprobantePagoUseCase,
            ListaComprobantePagoUseCase listaComprobantePagoUseCase,
            ObtenerComprobantePagoUseCase obtenerComprobantePagoUseCase
    ){
        return new ComprobantePagoServiceImpl(
                actualizarComprobantePagoUseCase,
                crearComprobantePagoUseCase,
                eliminarComprobantePagoUseCase,
                listaComprobantePagoUseCase,
                obtenerComprobantePagoUseCase
        );
    }
}
