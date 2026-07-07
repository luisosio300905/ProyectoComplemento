package org.luis.proyecto.application.service.laboratorio.impl;

import org.luis.proyecto.application.service.laboratorio.LaboratorioService;
import org.luis.proyecto.application.usecase.laboratorio.*;
import org.luis.proyecto.domain.model.Laboratorio;
import java.util.List;
import java.util.Optional;

public class LaboratorioServiceImpl implements LaboratorioService {

    private final CrearLaboratorioUseCase crearLaboratorioUseCase;
    private final ActualizarLaboratorioUseCase actualizarLaboratorioUseCase;
    private final EliminarLaboratorioUseCase eliminarLaboratorioUseCase;
    private final ObtenerLaboratorioUseCase obtenerLaboratorioUseCase;
    private final ListarLaboratoriosUseCase listarLaboratoriosUseCase;

    public LaboratorioServiceImpl(CrearLaboratorioUseCase crearLaboratorioUseCase,
                                  ActualizarLaboratorioUseCase actualizarLaboratorioUseCase,
                                  EliminarLaboratorioUseCase eliminarLaboratorioUseCase,
                                  ObtenerLaboratorioUseCase obtenerLaboratorioUseCase,
                                  ListarLaboratoriosUseCase listarLaboratoriosUseCase) {
        this.crearLaboratorioUseCase = crearLaboratorioUseCase;
        this.actualizarLaboratorioUseCase = actualizarLaboratorioUseCase;
        this.eliminarLaboratorioUseCase = eliminarLaboratorioUseCase;
        this.obtenerLaboratorioUseCase = obtenerLaboratorioUseCase;
        this.listarLaboratoriosUseCase = listarLaboratoriosUseCase;
    }

    @Override
    public Laboratorio crear(Laboratorio laboratorio) {
        return crearLaboratorioUseCase.crear(laboratorio);
    }

    @Override
    public Laboratorio actualizar(Integer id, Laboratorio laboratorio) {
        return actualizarLaboratorioUseCase.actualizar(id, laboratorio);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarLaboratorioUseCase.eliminar(id);
    }

    @Override
    public Optional<Laboratorio> obtenerPorId(Integer id) {
        return obtenerLaboratorioUseCase.obtenerPorId(id);
    }

    @Override
    public List<Laboratorio> listar() {
        return listarLaboratoriosUseCase.listar();
    }
}

