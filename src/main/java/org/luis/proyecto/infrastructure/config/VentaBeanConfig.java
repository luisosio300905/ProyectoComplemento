package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.venta.VentaService;
import org.luis.proyecto.application.service.venta.impl.VentaServiceImpl;
import org.luis.proyecto.application.usecase.venta.ActualizarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.CrearVentaUseCase;
import org.luis.proyecto.application.usecase.venta.EliminarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ListaVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ObtenerVentaUseCase;
import org.luis.proyecto.application.usecase.venta.impl.ActualizarVentaUseCaseImpl;
import org.luis.proyecto.application.usecase.venta.impl.CrearVentaUseCaseImpl;
import org.luis.proyecto.application.usecase.venta.impl.EliminarVentaUseCaseImpl;
import org.luis.proyecto.application.usecase.venta.impl.ListaVentaUseCaseImpl;
import org.luis.proyecto.application.usecase.venta.impl.ObtenerVentaUseCaseImpl;
import org.luis.proyecto.domain.repository.VentaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentaBeanConfig {

    @Bean
    public CrearVentaUseCase crearVentaUseCase(VentaRepository ventaRepository,
                                               org.luis.proyecto.application.usecase.diariocabecera.CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase,
                                               org.luis.proyecto.application.usecase.diariodetalle.CrearDiarioDetalleUseCase crearDiarioDetalleUseCase,
                                               org.luis.proyecto.application.service.mapeocuentas.MapeoVentaCuentasService mapeoVentaCuentasService) {
        return new CrearVentaUseCaseImpl(ventaRepository, crearDiarioCabeceraUseCase, crearDiarioDetalleUseCase, mapeoVentaCuentasService);
    }

    @Bean
    public ActualizarVentaUseCase actualizarVentaUseCase(VentaRepository ventaRepository) {
        return new ActualizarVentaUseCaseImpl(ventaRepository);
    }

    @Bean
    public EliminarVentaUseCase eliminarVentaUseCase(VentaRepository ventaRepository) {
        return new EliminarVentaUseCaseImpl(ventaRepository);
    }

    @Bean
    public ListaVentaUseCase listaVentasUseCase(VentaRepository ventaRepository) {
        return new ListaVentaUseCaseImpl(ventaRepository);
    }

    @Bean
    public ObtenerVentaUseCase obtenerVentaUseCase(VentaRepository ventaRepository) {
        return new ObtenerVentaUseCaseImpl(ventaRepository);
    }

    @Bean
    public VentaService ventaService
            (
            CrearVentaUseCase crearVentaUseCase,
            ActualizarVentaUseCase actualizarVentaUseCase,
            EliminarVentaUseCase eliminarVentaUseCase,
            ListaVentaUseCase listaVentasUseCase,
            ObtenerVentaUseCase obtenerVentaUseCase,
            org.luis.proyecto.application.service.balancegeneral.BalanceGeneralService balanceGeneralService
            ) {
        return new VentaServiceImpl
                (
                crearVentaUseCase,
                actualizarVentaUseCase,
                eliminarVentaUseCase,
                listaVentasUseCase,
                obtenerVentaUseCase,
                balanceGeneralService
        );
    }
}
