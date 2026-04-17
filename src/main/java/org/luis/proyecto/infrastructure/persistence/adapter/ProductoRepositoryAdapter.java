package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return productoMapper
                .toProducto(jpaProductoRepository.save(productoMapper.toProductoEntity(producto)));
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return jpaProductoRepository
                .findById(id).map(p -> productoMapper.toProducto(p));
    }

    @Override
    public Optional<Producto> findByCodigo(String codigo) {
        return jpaProductoRepository
                .findByCodigo(codigo)
                .map(p -> productoMapper.toProducto(p));
    }

    @Override
    public void deleteById(Integer id) {
        jpaProductoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoMapper.toProductoList(jpaProductoRepository.findAll());
    }
}
