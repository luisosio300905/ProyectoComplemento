package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.balancegeneral.BalanceGeneralService;
import org.luis.proyecto.application.service.balancegeneral.impl.BalanceGeneralServiceImpl;
import org.luis.proyecto.application.usecase.diariocabecera.ObtenerBalanceGeneralUseCase;
import org.luis.proyecto.application.usecase.diariocabecera.impl.ObtenerBalanceGeneralUseCaseImpl;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceGeneralBeanConfig {

    @Bean
    public ObtenerBalanceGeneralUseCase obtenerBalanceGeneralUseCase(DiarioCabeceraRepository diarioCabeceraRepository) {
        return new ObtenerBalanceGeneralUseCaseImpl(diarioCabeceraRepository);
    }

    @Bean
    public BalanceGeneralService balanceGeneralService(ObtenerBalanceGeneralUseCase obtenerBalanceGeneralUseCase,
                                                       DiarioDetalleRepository diarioDetalleRepository) {
        return new BalanceGeneralServiceImpl(obtenerBalanceGeneralUseCase, diarioDetalleRepository);
    }
}

