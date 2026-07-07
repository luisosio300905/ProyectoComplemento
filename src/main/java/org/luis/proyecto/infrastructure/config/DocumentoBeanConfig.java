package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.service.detalleventa.DetalleVentaService;
import org.luis.proyecto.application.service.detalleventa.impl.DetalleVentaServiceImpl;
import org.luis.proyecto.application.service.documento.DocumentoService;
import org.luis.proyecto.application.service.documento.impl.DocumentoServiceImpl;
import org.luis.proyecto.application.usecase.detalleventa.*;
import org.luis.proyecto.application.usecase.detalleventa.impl.*;
import org.luis.proyecto.application.usecase.documento.*;
import org.luis.proyecto.application.usecase.documento.impl.*;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;
import org.luis.proyecto.domain.repository.DocumentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentoBeanConfig {

    @Bean
    public CrearDocumentoUseCase crearDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new CrearDocumentoUseCaseImpl(documentoRepository);
    }

    @Bean
    public ActualizarDocumentoUseCase actualizarDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new ActualizarDocumentoUseCaseImpl(documentoRepository);
    }

    @Bean
    public EliminarDocumentoUseCase eliminarDocumentoCase(DocumentoRepository documentoRepository) {
        return new EliminarDocumentoUseCaseImpl(documentoRepository);
    }

    @Bean
    public ObtenerDocumentoUseCase obtenerDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new ObtenerDocumentoUseCaseImpl(documentoRepository);
    }

    @Bean
    public ListaDocumentoUseCase listaDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new ListaDocumentoUseCaseImpl(documentoRepository);
    }

    @Bean
    public DocumentoService documentoService(
            ActualizarDocumentoUseCase actualizarDocumentoUseCase,
            CrearDocumentoUseCase crearDocumentoUseCase,
            EliminarDocumentoUseCase eliminarDocumentoUseCase,
            ListaDocumentoUseCase listaDocumentoUseCase,
            ObtenerDocumentoUseCase obtenerDocumentoUseCase
    ){
        return new DocumentoServiceImpl(
                actualizarDocumentoUseCase,
                crearDocumentoUseCase,
                eliminarDocumentoUseCase,
                listaDocumentoUseCase,
                obtenerDocumentoUseCase
        );
    }
}