package org.luis.proyecto.domain.repository;

import org.luis.proyecto.domain.model.Laboratorio;
import java.util.List;
import java.util.Optional;

public interface LaboratorioRepository {
    Laboratorio save(Laboratorio laboratorio);
    Optional<Laboratorio> findById(Integer id);
    void deleteById(Integer id);
    List<Laboratorio> findAll();
}
