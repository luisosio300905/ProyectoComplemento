package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.compra.CompraService;
import org.luis.proyecto.application.service.compra.impl.CompraServiceImpl;
import org.luis.proyecto.application.usecase.compra.*;
import org.luis.proyecto.application.usecase.compra.impl.*;
import org.luis.proyecto.domain.repository.CompraRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompraBeanConfig {

    @Bean
    public CrearCompraUseCase crearCompraUseCase(CompraRepository compraRepository) {
        return new CrearCompraUseCaseImpl(compraRepository);
    }

    @Bean
    public ActualizarCompraUseCase actualizarCompraUseCase(CompraRepository compraRepository) {
        return new ActualizarCompraUseCaseImpl(compraRepository);
    }

    @Bean
    public EliminarCompraUseCase eliminarCompraUseCase(CompraRepository compraRepository) {
        return new EliminarCompraUseCaseImpl(compraRepository);
    }

    @Bean
    public ObtenerCompraUseCase obtenerCompraUseCase(CompraRepository compraRepository) {
        return new ObtenerCompraUseCaseImpl(compraRepository);
    }

    @Bean
    public ListaComprasUseCase listaComprasUseCase(CompraRepository compraRepository) {
        return new ListaComprasUseCaseImpl(compraRepository);
    }

    @Bean
    public CompraService compraService(
            CrearCompraUseCase crearCompraUseCase,
            ActualizarCompraUseCase actualizarCompraUseCase,
            EliminarCompraUseCase eliminarCompraUseCase,
            ListaComprasUseCase listaComprasUseCase,
            ObtenerCompraUseCase obtenerCompraUseCase
    ) {
        return new CompraServiceImpl(
                crearCompraUseCase,
                actualizarCompraUseCase,
                eliminarCompraUseCase,
                listaComprasUseCase,
                obtenerCompraUseCase
        );
    }
}

