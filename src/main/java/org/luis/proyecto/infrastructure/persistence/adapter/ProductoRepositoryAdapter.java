package org.luis.proyecto.infrastructure.persistence.adapter;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaProductoRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class ProductoRepositoryAdapter implements ProductoRepository {
    private final JpaProductoRepository jpaProductoRepository;
    private final ProductoMapper productoMapper;
    public ProductoRepositoryAdapter(JpaProductoRepository jpaProductoRepository, ProductoMapper productoMapper) {
        this.jpaProductoRepository = jpaProductoRepository;
        this.productoMapper = productoMapper;
    }
    @Override
    public Producto save(Producto producto) {
        return productoMapper.toDomain(jpaProductoRepository.save(productoMapper.toEntity(producto)));
    }
    @Override
    public Optional<Producto> findById(Integer id) {
        return jpaProductoRepository.findById(id).map(productoMapper::toDomain);
    }
    @Override
    public void deleteById(Integer id) {
        jpaProductoRepository.deleteById(id);
    }
    @Override
    public List<Producto> findAll() {
        return jpaProductoRepository.findAll().stream().map(productoMapper::toDomain).collect(Collectors.toList());
    }
}
