package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.application.service.producto.impl.ProductoServiceImpl;
import org.luis.proyecto.application.usecase.cliente.CrearClienteUseCase;
import org.luis.proyecto.application.usecase.cliente.impl.CrearClienteUseCaseImpl;
import org.luis.proyecto.application.usecase.producto.*;
import org.luis.proyecto.application.usecase.producto.impl.*;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.springframework.context.annotation.Bean;

public class ClienteBeanConfig {
    @Bean
    public CrearClienteUseCase crearClienteUseCase(ClienteRepository clienteRepository) {
        return new CrearClienteUseCaseImpl(clienteRepository);
    }


}
