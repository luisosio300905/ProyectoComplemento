package org.luis.proyecto.application.port;
import org.luis.proyecto.domain.model.Documento;
import java.util.List;
import java.util.Optional;
public interface DocumentoPort {
    Documento save(Documento obj);
    Optional<Documento> findById(String id);
    List<Documento> findAll();
    void deleteById(String id);
}
