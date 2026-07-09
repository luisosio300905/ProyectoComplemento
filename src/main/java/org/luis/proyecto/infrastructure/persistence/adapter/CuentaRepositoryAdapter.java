package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.domain.repository.CuentaRepository;
import org.luis.proyecto.infrastructure.mapper.CuentaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.CuentaEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaCuentaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Cuenta> findAllWithChildren() {
        List<CuentaEntity> entities = jpaCuentaRepository.findAll();
        return entities.stream().map(this::toCuentaWithChildren).toList();
    }

    @Override
    public boolean existsById(String id) {
        return jpaCuentaRepository.existsById(id);
    }

    private Cuenta toCuentaWithChildren(CuentaEntity entity) {
        if (entity == null) return null;
        
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(entity.getCuentaId());
        cuenta.setCuentaDescripcion(entity.getCuentaDescripcion());
        cuenta.setCuentaEstado(entity.getCuentaEstado());
        cuenta.setUsrSistema(entity.getUsrSistema());
        cuenta.setFecSistema(entity.getFecSistema());
        cuenta.setHrsSistema(entity.getHrsSistema());
        
        if (entity.getSubCuentas() != null) {
            cuenta.setSubCuentas(entity.getSubCuentas().stream().map(scEntity -> {
                SubCuenta sc = new SubCuenta();
                sc.setCuentaId(scEntity.getCuentaId());
                sc.setSubCtaId(scEntity.getSubCtaId());
                sc.setSubCtaDescripcion(scEntity.getSubCtaDescripcion());
                sc.setSubCtaEstado(scEntity.getSubCtaEstado());
                sc.setUsrSistema(scEntity.getUsrSistema());
                sc.setFecSistema(scEntity.getFecSistema());
                sc.setHrsSistema(scEntity.getHrsSistema());
                
                if (scEntity.getDivisionarias() != null) {
                    sc.setDivisionarias(scEntity.getDivisionarias().stream().map(dEntity -> {
                        Divisionaria d = new Divisionaria();
                        d.setCuentaId(dEntity.getCuentaId());
                        d.setSubCtaId(dEntity.getSubCtaId());
                        d.setDivisioId(dEntity.getDivisioId());
                        d.setDivisioDescripcion(dEntity.getDivisioDescripcion());
                        d.setDivisioEstad(dEntity.getDivisioEstad());
                        d.setUsrSistema(dEntity.getUsrSistema());
                        d.setFecSistema(dEntity.getFecSistema());
                        d.setHrsSistema(dEntity.getHrsSistema());
                        
                        if (dEntity.getSubDivisionarias() != null) {
                            d.setSubDivisionarias(dEntity.getSubDivisionarias().stream().map(sdEntity -> {
                                SubDivisionaria sd = new SubDivisionaria();
                                sd.setCuentaId(sdEntity.getCuentaId());
                                sd.setSubCtaId(sdEntity.getSubCtaId());
                                sd.setDivisioId(sdEntity.getDivisioId());
                                sd.setSubDivId(sdEntity.getSubDivId());
                                sd.setSubDivDescripcion(sdEntity.getSubDivDescripcion());
                                sd.setSubDivCenCost(sdEntity.getSubDivCenCost());
                                sd.setSubDivCtaCte(sdEntity.getSubDivCtaCte());
                                sd.setSubDivAnalisis(sdEntity.getSubDivAnalisis());
                                sd.setSubDivEstado(sdEntity.getSubDivEstado());
                                sd.setTipCtaId(sdEntity.getTipCtaId());
                                sd.setSubDivNumDigSunat(sdEntity.getSubDivNumDigSunat());
                                sd.setUsrSistema(sdEntity.getUsrSistema());
                                sd.setFecSistema(sdEntity.getFecSistema());
                                sd.setHrsSistema(sdEntity.getHrsSistema());
                                sd.setCta5(sdEntity.getCta5());
                                sd.setCta8(sdEntity.getCta8());
                                return sd;
                            }).toList());
                        } else {
                            d.setSubDivisionarias(List.of());
                        }
                        return d;
                    }).toList());
                } else {
                    sc.setDivisionarias(List.of());
                }
                return sc;
            }).toList());
        } else {
            cuenta.setSubCuentas(List.of());
        }
        
        return cuenta;
    }
}

