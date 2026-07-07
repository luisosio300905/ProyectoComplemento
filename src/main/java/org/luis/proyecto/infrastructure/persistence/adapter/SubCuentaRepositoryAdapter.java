package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.domain.repository.SubCuentaRepository;
import org.luis.proyecto.infrastructure.mapper.SubCuentaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;
import org.luis.proyecto.infrastructure.persistence.repository.JpaSubCuentaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubCuentaRepositoryAdapter implements SubCuentaRepository {
    private final JpaSubCuentaRepository jpaSubCuentaRepository;
    private final SubCuentaMapper subCuentaMapper;

    public SubCuentaRepositoryAdapter(JpaSubCuentaRepository jpaSubCuentaRepository, SubCuentaMapper subCuentaMapper) {
        this.jpaSubCuentaRepository = jpaSubCuentaRepository;
        this.subCuentaMapper = subCuentaMapper;
    }

    @Override
    public SubCuenta save(SubCuenta subCuenta) {
        return subCuentaMapper.toSubCuenta(jpaSubCuentaRepository.save(subCuentaMapper.toSubCuentaEntity(subCuenta)));
    }

    @Override
    public Optional<SubCuenta> findById(SubCuentaPK id) {
        return jpaSubCuentaRepository.findById(id).map(subCuentaMapper::toSubCuenta);
    }

    @Override
    public void deleteById(SubCuentaPK id) {
        jpaSubCuentaRepository.deleteById(id);
    }

    @Override
    public List<SubCuenta> findAll() {
        return subCuentaMapper.toSubCuentaList(jpaSubCuentaRepository.findAll());
    }

    @Override
    public List<SubCuenta> findByCuentaId(String cuentaId) {
        return subCuentaMapper.toSubCuentaList(jpaSubCuentaRepository.findByCuentaId(cuentaId));
    }

    @Override
    public void deleteByCuentaId(String cuentaId) {
        jpaSubCuentaRepository.deleteByCuentaId(cuentaId);
    }
}

