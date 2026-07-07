package org.luis.proyecto.application.service.diariocabecera.impl;

import org.luis.proyecto.application.service.diariocabecera.DiarioCabeceraService;
import org.luis.proyecto.application.usecase.diariocabecera.*;
import org.luis.proyecto.domain.model.DiarioCabecera;

import java.util.List;

public class DiarioCabeceraServiceImpl implements DiarioCabeceraService {
    private final CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase;
    private final ActualizarDiarioCabeceraUseCase actualizarDiarioCabeceraUseCase;
    private final EliminarDiarioCabeceraUseCase eliminarDiarioCabeceraUseCase;
    private final ListaDiarioCabeceraUseCase listaDiarioCabeceraUseCase;
    private final ObtenerDiarioCabeceraUseCase obtenerDiarioCabeceraUseCase;

    public DiarioCabeceraServiceImpl(CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase, ActualizarDiarioCabeceraUseCase actualizarDiarioCabeceraUseCase, EliminarDiarioCabeceraUseCase eliminarDiarioCabeceraUseCase, ListaDiarioCabeceraUseCase listaDiarioCabeceraUseCase, ObtenerDiarioCabeceraUseCase obtenerDiarioCabeceraUseCase) {
        this.crearDiarioCabeceraUseCase = crearDiarioCabeceraUseCase;
        this.actualizarDiarioCabeceraUseCase = actualizarDiarioCabeceraUseCase;
        this.eliminarDiarioCabeceraUseCase = eliminarDiarioCabeceraUseCase;
        this.listaDiarioCabeceraUseCase = listaDiarioCabeceraUseCase;
        this.obtenerDiarioCabeceraUseCase = obtenerDiarioCabeceraUseCase;
    }

    @Override
    public DiarioCabecera crear(DiarioCabecera diarioCabecera) {
        return crearDiarioCabeceraUseCase.crear(diarioCabecera);
    }

    @Override
    public DiarioCabecera actualizar(Long id, DiarioCabecera diarioCabecera) {
        return actualizarDiarioCabeceraUseCase.actualizar(id, diarioCabecera);
    }

    @Override
    public void eliminar(Long id) {
        eliminarDiarioCabeceraUseCase.eliminar(id);
    }

    @Override
    public DiarioCabecera obtenerById(Long id) {
        return obtenerDiarioCabeceraUseCase.obtenerById(id);
    }

    @Override
    public DiarioCabecera obtenerByEmpresaId(String empresaId) {
        return obtenerDiarioCabeceraUseCase.obtenerByEmpresaId(empresaId);
    }

    @Override
    public List<DiarioCabecera> obtenerTodos() {
        return listaDiarioCabeceraUseCase.obtenerTodos();
    }

    @Override
    public List<DiarioCabecera> obtenerPorAnoYMes(Integer ano, Integer mes) {
        return listaDiarioCabeceraUseCase.obtenerPorAnoYMes(ano, mes);
    }
}

