package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.divisionaria.DivisionariaService;
import org.luis.proyecto.application.service.divisionaria.impl.DivisionariaServiceImpl;
import org.luis.proyecto.domain.repository.DivisionariaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisionariaBeanConfig {

    @Bean
    public DivisionariaService divisionariaService(DivisionariaRepository divisionariaRepository) {
        return new DivisionariaServiceImpl(divisionariaRepository);
    }
}

