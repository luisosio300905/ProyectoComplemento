package org.luis.proyecto.application.service.cuenta.impl;

import org.luis.proyecto.application.service.cuenta.CuentaService;
import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.domain.repository.CuentaRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.infrastructure.rest.response.CuentaJerarquiaResponse;

import java.util.List;

public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta crear(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta actualizar(String id, Cuenta cuenta) {
        cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
        cuenta.setCuentaId(id);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminar(String id) {
        cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta obtenerById(String id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    @Override
    public List<Cuenta> obtenerTodos() {
        return cuentaRepository.findAll();
    }

    @Override
    public List<CuentaJerarquiaResponse> obtenerJerarquia() {
        List<Cuenta> cuentas = cuentaRepository.findAllWithChildren();
        return cuentas.stream().map(this::toJerarquiaResponse).toList();
    }

    private CuentaJerarquiaResponse toJerarquiaResponse(Cuenta cuenta) {
        List<CuentaJerarquiaResponse.SubCuentaJerarquiaResponse> subCuentas = cuenta.getSubCuentas() == null ? List.of() :
                cuenta.getSubCuentas().stream().map(sc -> {
                    List<CuentaJerarquiaResponse.SubCuentaJerarquiaResponse.DivisionariaJerarquiaResponse> divisionarias = sc.getDivisionarias() == null ? List.of() :
                            sc.getDivisionarias().stream().map(d -> {
                                List<CuentaJerarquiaResponse.SubCuentaJerarquiaResponse.DivisionariaJerarquiaResponse.SubDivisionariaJerarquiaResponse> subDivs = d.getSubDivisionarias() == null ? List.of() :
                                        d.getSubDivisionarias().stream().map(sd -> new CuentaJerarquiaResponse.SubCuentaJerarquiaResponse.DivisionariaJerarquiaResponse.SubDivisionariaJerarquiaResponse(
                                                sd.getSubDivId(),
                                                sd.getSubDivDescripcion(),
                                                sd.getSubDivEstado()
                                        )).toList();
                                return new CuentaJerarquiaResponse.SubCuentaJerarquiaResponse.DivisionariaJerarquiaResponse(
                                        d.getDivisioId(),
                                        d.getDivisioDescripcion(),
                                        d.getDivisioEstad(),
                                        subDivs
                                );
                            }).toList();
                    return new CuentaJerarquiaResponse.SubCuentaJerarquiaResponse(
                            sc.getSubCtaId(),
                            sc.getSubCtaDescripcion(),
                            sc.getSubCtaEstado(),
                            divisionarias
                    );
                }).toList();
        return new CuentaJerarquiaResponse(
                cuenta.getCuentaId(),
                cuenta.getCuentaDescripcion(),
                cuenta.getCuentaEstado(),
                subCuentas
        );
    }
}

