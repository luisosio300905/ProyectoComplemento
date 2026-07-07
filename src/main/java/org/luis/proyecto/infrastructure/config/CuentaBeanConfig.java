package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.cuenta.CuentaService;
import org.luis.proyecto.application.service.cuenta.impl.CuentaServiceImpl;
import org.luis.proyecto.domain.repository.CuentaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuentaBeanConfig {

    @Bean
    public CuentaService cuentaService(CuentaRepository cuentaRepository) {
        return new CuentaServiceImpl(cuentaRepository);
    }
}

