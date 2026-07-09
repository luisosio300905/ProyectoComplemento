package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.CrearProductoUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrearProductoUseCaseImpl implements CrearProductoUseCase {
    private final ProductoRepository productoRepository;
    public CrearProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public Producto crear(Producto producto) {
        if (producto.getCodpro() == null || producto.getCodpro().trim().isEmpty()) {
            List<Producto> todos = productoRepository.findAll();
            int maxNum = 0;
            for (Producto p : todos) {
                String cp = p.getCodpro();
                if (cp != null && cp.toUpperCase().startsWith("PROD")) {
                    try {
                        int num = Integer.parseInt(cp.substring(4));
                        if (num > maxNum) {
                            maxNum = num;
                        }
                    } catch (NumberFormatException e) {
                        // Ignore malformed codes
                    }
                }
            }
            int nextNum = maxNum + 1;
            String nextCodpro = String.format("PROD%02d", nextNum);
            producto.setCodpro(nextCodpro);
        }
        return productoRepository.save(producto);
    }
}
