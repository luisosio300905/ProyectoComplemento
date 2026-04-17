package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.application.service.producto.impl.ProductoServiceImpl;
import org.luis.proyecto.application.usecase.producto.*;
import org.luis.proyecto.application.usecase.producto.impl.*;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoBeanConfig {

    @Bean
    public CrearProductoUseCase crearProductoUseCase(ProductoRepository productoRepository) {
        return new CrearProductoUseCaseImpl(productoRepository);
    }

    @Bean
    public ActualizarProductoUseCase actualizarProductoUseCase(ProductoRepository productoRepository) {
        return new ActualizarProductoUseCaseImpl(productoRepository);
    }

    @Bean
    public EliminarProductoUseCase eliminarProductoUseCase(ProductoRepository productoRepository) {
        return new EliminarProductoUseCaseImpl(productoRepository);
    }

    @Bean
    public ListaProductosUseCase listaProductosUseCase(ProductoRepository productoRepository) {
        return new ListaProductosUseCaseImpl(productoRepository);
    }

    @Bean
    public ObtenerProductoUseCase obtenerProductoUseCase(ProductoRepository productoRepository) {
        return new ObtenerProductoUseCaseImpl(productoRepository);
    }

    @Bean
    public ProductoService productoService
            (
            CrearProductoUseCase crearProductoUseCase,
            ActualizarProductoUseCase actualizarProductoUseCase,
            EliminarProductoUseCase eliminarProductoUseCase,
            ListaProductosUseCase listaProductosUseCase,
            ProductoMapper productoMapper,
            ObtenerProductoUseCase obtenerProductoUseCase
            ) {
        return new ProductoServiceImpl
                (
                crearProductoUseCase,
                actualizarProductoUseCase,
                eliminarProductoUseCase,
                listaProductosUseCase,
                obtenerProductoUseCase,
                productoMapper
        );
    }
}
