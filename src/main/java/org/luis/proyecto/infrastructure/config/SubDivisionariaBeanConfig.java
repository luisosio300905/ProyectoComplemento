package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.subdivisionaria.SubDivisionariaService;
import org.luis.proyecto.application.service.subdivisionaria.impl.SubDivisionariaServiceImpl;
import org.luis.proyecto.domain.repository.SubDivisionariaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubDivisionariaBeanConfig {

    @Bean
    public SubDivisionariaService subDivisionariaService(SubDivisionariaRepository subDivisionariaRepository) {
        return new SubDivisionariaServiceImpl(subDivisionariaRepository);
    }
}

