package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.mapeocuentas.MapeoVentaCuentasService;
import org.luis.proyecto.application.service.mapeocuentas.impl.MapeoVentaCuentasServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeoVentaCuentasBeanConfig {

    @Bean
    public MapeoVentaCuentasService mapeoVentaCuentasService() {
        return new MapeoVentaCuentasServiceImpl();
    }
}
