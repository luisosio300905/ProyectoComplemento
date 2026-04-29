package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.cliente.ClienteService;
import org.luis.proyecto.application.service.cliente.impl.ClienteServiceImpl;
import org.luis.proyecto.application.usecase.cliente.*;
import org.luis.proyecto.application.usecase.cliente.impl.*;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.luis.proyecto.infrastructure.mapper.ClienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {
    @Bean
    public CrearClienteUseCase crearClienteUseCase(ClienteRepository clienteRepository) {
        return new CrearClienteUseCaseImpl(clienteRepository);
    }
    @Bean
    public ActualizarClienteUseCase actualizarClienteUseCase(ClienteRepository clienteRepository) {
        return new ActualizarClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public EliminarClienteUseCase eliminarClienteUseCase(ClienteRepository clienteRepository) {
        return new EliminarClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public ListaClientesUseCase listaClientesUseCase(ClienteRepository clienteRepository) {
        return new ListaClientesUseCaseImpl(clienteRepository);
    }

    @Bean
    public ObtenerClienteUseCase obtenerClienteUseCase(ClienteRepository clienteRepository) {
        return new ObtenerClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public ClienteService clienteService(
            CrearClienteUseCase crearClienteUseCase,
            ActualizarClienteUseCase actualizarClienteUseCase,
            EliminarClienteUseCase eliminarClienteUseCase,
            ListaClientesUseCase listaClientesUseCase,
            ObtenerClienteUseCase obtenerClienteUseCase,
            ClienteMapper clienteMapper
    ) {
        return new ClienteServiceImpl(
                crearClienteUseCase,
                actualizarClienteUseCase,
                eliminarClienteUseCase,
                listaClientesUseCase,
                obtenerClienteUseCase,
                clienteMapper
        );
    }

}
