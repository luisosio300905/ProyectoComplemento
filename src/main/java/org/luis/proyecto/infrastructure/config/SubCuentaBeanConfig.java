package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.subcuenta.SubCuentaService;
import org.luis.proyecto.application.service.subcuenta.impl.SubCuentaServiceImpl;
import org.luis.proyecto.domain.repository.SubCuentaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubCuentaBeanConfig {

    @Bean
    public SubCuentaService subCuentaService(SubCuentaRepository subCuentaRepository) {
        return new SubCuentaServiceImpl(subCuentaRepository);
    }
}

