package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.tipodocumentoidentidad.TipoDocumentoIdentidadService;
import org.luis.proyecto.application.service.tipodocumentoidentidad.impl.TipoDocumentoIdentidadServiceImpl;
import org.luis.proyecto.application.usecase.tipodocumentoidentidad.*;
import org.luis.proyecto.application.usecase.tipodocumentoidentidad.impl.*;
import org.luis.proyecto.domain.repository.TipoDocumentoIdentidadRepository;
import org.luis.proyecto.infrastructure.mapper.TipoDocumentoIdentidadMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoDocumentoIdentidadBeanConfig {

    @Bean
    public CrearTipoDocumentoIdentidadUseCase crearTipoDocumentoIdentidadUseCase(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        return new CrearTipoDocumentoIdentidadUseCaseImpl(tipodocumentoidentidadRepository);
    }

    @Bean
    public ActualizarTipoDocumentoIdentidadUseCase actualizarTipoDocumentoIdentidadUseCase(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        return new ActualizarTipoDocumentoIdentidadUseCaseImpl(tipodocumentoidentidadRepository);
    }

    @Bean
    public EliminarTipoDocumentoIdentidadUseCase eliminarTipoDocumentoIdentidadUseCase(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        return new EliminarTipoDocumentoIdentidadUseCaseImpl(tipodocumentoidentidadRepository);
    }

    @Bean
    public ListaTipoDocumentoIdentidadsUseCase listaTipoDocumentoIdentidadsUseCase(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        return new ListaTipoDocumentoIdentidadsUseCaseImpl(tipodocumentoidentidadRepository);
    }

    @Bean
    public ObtenerTipoDocumentoIdentidadUseCase obtenerTipoDocumentoIdentidadUseCase(TipoDocumentoIdentidadRepository tipodocumentoidentidadRepository) {
        return new ObtenerTipoDocumentoIdentidadUseCaseImpl(tipodocumentoidentidadRepository);
    }

    @Bean
    public TipoDocumentoIdentidadService tipodocumentoidentidadService
            (
                    CrearTipoDocumentoIdentidadUseCase crearTipoDocumentoIdentidadUseCase,
                    ActualizarTipoDocumentoIdentidadUseCase actualizarTipoDocumentoIdentidadUseCase,
                    EliminarTipoDocumentoIdentidadUseCase eliminarTipoDocumentoIdentidadUseCase,
                    ListaTipoDocumentoIdentidadsUseCase listaTipoDocumentoIdentidadsUseCase,
                    TipoDocumentoIdentidadMapper tipodocumentoidentidadMapper,
                    ObtenerTipoDocumentoIdentidadUseCase obtenerTipoDocumentoIdentidadUseCase
            ) {
        return new TipoDocumentoIdentidadServiceImpl
                (
                        crearTipoDocumentoIdentidadUseCase,
                        actualizarTipoDocumentoIdentidadUseCase,
                        eliminarTipoDocumentoIdentidadUseCase,
                        listaTipoDocumentoIdentidadsUseCase,
                        obtenerTipoDocumentoIdentidadUseCase,
                        tipodocumentoidentidadMapper
                );
    }

}
