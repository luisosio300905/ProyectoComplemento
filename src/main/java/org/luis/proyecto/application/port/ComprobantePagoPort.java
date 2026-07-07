package org.luis.proyecto.application.port;
import org.luis.proyecto.domain.model.ComprobantePago;
import java.util.List;
import java.util.Optional;
public interface ComprobantePagoPort {
    ComprobantePago save(ComprobantePago obj);
    Optional<ComprobantePago> findById(String id);
    List<ComprobantePago> findAll();
    void deleteById(String id);
}
