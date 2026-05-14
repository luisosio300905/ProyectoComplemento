package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.proveedor.ProveedorService;
import org.luis.proyecto.application.service.proveedor.impl.ProveedorServiceImpl;
import org.luis.proyecto.application.usecase.proveedor.*;
import org.luis.proyecto.application.usecase.proveedor.impl.*;
import org.luis.proyecto.domain.repository.ProveedorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProveedorBeanConfig {

    @Bean
    public CrearProveedorUseCase crearProveedorUseCase(ProveedorRepository proveedorRepository) {
        return new CrearProveedorUseCaseImpl(proveedorRepository);
    }

    @Bean
    public ActualizarProveedorUseCase actualizarProveedorUseCase(ProveedorRepository proveedorRepository) {
        return new ActualizarProveedorUseCaseImpl(proveedorRepository);
    }

    @Bean
    public EliminarProveedorUseCase eliminarProveedorUseCase(ProveedorRepository proveedorRepository) {
        return new EliminarProveedorUseCaseImpl(proveedorRepository);
    }

    @Bean
    public ObtenerProveedorUseCase obtenerProveedorUseCase(ProveedorRepository proveedorRepository) {
        return new ObtenerProveedorUseCaseImpl(proveedorRepository);
    }

    @Bean
    public ListaProveedoresUseCase listaProveedoresUseCase(ProveedorRepository proveedorRepository) {
        return new ListaProveedoresUseCaseImpl(proveedorRepository);
    }

    @Bean
    public ProveedorService proveedorService(
            CrearProveedorUseCase crearProveedorUseCase,
            ActualizarProveedorUseCase actualizarProveedorUseCase,
            EliminarProveedorUseCase eliminarProveedorUseCase,
            ListaProveedoresUseCase listaProveedoresUseCase,
            ObtenerProveedorUseCase obtenerProveedorUseCase
    ) {
        return new ProveedorServiceImpl(
                crearProveedorUseCase,
                actualizarProveedorUseCase,
                eliminarProveedorUseCase,
                listaProveedoresUseCase,
                obtenerProveedorUseCase
        );
    }
}

