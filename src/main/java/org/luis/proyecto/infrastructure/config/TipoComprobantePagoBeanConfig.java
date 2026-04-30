package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.tipocomprobantepago.TipoComprobantePagoService;
import org.luis.proyecto.application.service.tipocomprobantepago.impl.TipoComprobantePagoServiceImpl;
import org.luis.proyecto.application.usecase.tipocomprobantepago.*;
import org.luis.proyecto.application.usecase.tipocomprobantepago.impl.*;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoComprobantePagoBeanConfig {

    @Bean
    public CrearTipoComprobantePagoUseCase crearTipoComprobantePagoUseCase(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        return new CrearTipoComprobantePagoUseCaseImpl(tipoComprobantePagoRepository);
    }

    @Bean
    public ActualizarTipoComprobantePagoUseCase actualizarTipoComprobantePagoUseCase(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        return new ActualizarTipoComprobantePagoUseCaseImpl(tipoComprobantePagoRepository);
    }

    @Bean
    public EliminarTipoComprobantePagoUseCase eliminarTipoComprobantePagoUseCase(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        return new EliminarTipoComprobantePagoUseCaseImpl(tipoComprobantePagoRepository);
    }

    @Bean
    public ListaTipoComprobantePagosUseCase listaTipoComprobantePagosUseCase(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        return new ListaTipoComprobantePagosUseCaseImpl(tipoComprobantePagoRepository);
    }

    @Bean
    public ObtenerTipoComprobantePagoUseCase obtenerTipoComprobantePagoUseCase(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        return new ObtenerTipoComprobantePagoUseCaseImpl(tipoComprobantePagoRepository);
    }

    @Bean
    public TipoComprobantePagoService tipoComprobantePagoService(
            CrearTipoComprobantePagoUseCase crearTipoComprobantePagoUseCase,
            ActualizarTipoComprobantePagoUseCase actualizarTipoComprobantePagoUseCase,
            EliminarTipoComprobantePagoUseCase eliminarTipoComprobantePagoUseCase,
            ListaTipoComprobantePagosUseCase listaTipoComprobantePagosUseCase,
            ObtenerTipoComprobantePagoUseCase obtenerTipoComprobantePagoUseCase) {
        return new TipoComprobantePagoServiceImpl(
                crearTipoComprobantePagoUseCase,
                actualizarTipoComprobantePagoUseCase,
                eliminarTipoComprobantePagoUseCase,
                listaTipoComprobantePagosUseCase,
                obtenerTipoComprobantePagoUseCase
        );
    }
}