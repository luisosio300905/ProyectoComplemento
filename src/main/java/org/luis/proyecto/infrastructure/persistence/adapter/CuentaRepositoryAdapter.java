package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.domain.repository.CuentaRepository;
import org.luis.proyecto.infrastructure.mapper.CuentaMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaCuentaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CuentaRepositoryAdapter implements CuentaRepository {
    private final JpaCuentaRepository jpaCuentaRepository;
    private final CuentaMapper cuentaMapper;

    public CuentaRepositoryAdapter(JpaCuentaRepository jpaCuentaRepository, CuentaMapper cuentaMapper) {
        this.jpaCuentaRepository = jpaCuentaRepository;
        this.cuentaMapper = cuentaMapper;
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaMapper.toCuenta(jpaCuentaRepository.save(cuentaMapper.toCuentaEntity(cuenta)));
    }

    @Override
    public Optional<Cuenta> findById(String id) {
        return jpaCuentaRepository.findById(id).map(cuentaMapper::toCuenta);
    }

    @Override
    public void deleteById(String id) {
        jpaCuentaRepository.deleteById(id);
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaMapper.toCuentaList(jpaCuentaRepository.findAll());
    }

    @Override
    public boolean existsById(String id) {
        return jpaCuentaRepository.existsById(id);
    }
}

