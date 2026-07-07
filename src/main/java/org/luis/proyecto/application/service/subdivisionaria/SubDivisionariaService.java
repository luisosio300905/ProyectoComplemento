package org.luis.proyecto.application.service.subdivisionaria;

import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;

import java.util.List;

public interface SubDivisionariaService {
    SubDivisionaria crear(SubDivisionaria subDivisionaria);
    SubDivisionaria actualizar(SubDivisionariaPK id, SubDivisionaria subDivisionaria);
    void eliminar(SubDivisionariaPK id);
    SubDivisionaria obtenerById(SubDivisionariaPK id);
    List<SubDivisionaria> obtenerTodos();
    List<SubDivisionaria> obtenerPorDivisionaria(String cuentaId, String subCtaId, String divisioId);
    void eliminarPorDivisionaria(String cuentaId, String subCtaId, String divisioId);
}

