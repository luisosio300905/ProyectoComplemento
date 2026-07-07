package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.ActualizarClienteUseCase;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActualizarClienteUseCaseImpl implements ActualizarClienteUseCase {
    private final ClienteRepository clienteRepository;
    public ActualizarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente actualizar(Integer id, Cliente c) {
        Cliente curr = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        curr.setClienDescripcion(c.getClienDescripcion());
        curr.setClienRazSoc(c.getClienRazSoc());
        curr.setClienNomCor(c.getClienNomCor());
        curr.setClienSiglas(c.getClienSiglas());
        curr.setTipDocIdenId(c.getTipDocIdenId());
        curr.setClienDoc(c.getClienDoc());
        curr.setClienRegCom(c.getClienRegCom());
        curr.setClienDireccion(c.getClienDireccion());
        curr.setClienTelef01(c.getClienTelef01());
        curr.setClienTelef02(c.getClienTelef02());
        curr.setClienFax(c.getClienFax());
        curr.setClienCelular(c.getClienCelular());
        curr.setClienMail(c.getClienMail());
        curr.setClienWeb(c.getClienWeb());
        curr.setClienContacto(c.getClienContacto());
        curr.setClienFecIng(c.getClienFecIng());
        curr.setClienEstado(c.getClienEstado());
        curr.setClienGiro(c.getClienGiro());
        curr.setClienUltVta(c.getClienUltVta());
        curr.setCtaCteId(c.getCtaCteId());
        curr.setDptoGeoId(c.getDptoGeoId());
        curr.setProvGeoId(c.getProvGeoId());
        curr.setDistGeoId(c.getDistGeoId());
        curr.setUsrSistema(c.getUsrSistema());
        curr.setFecSistema(c.getFecSistema());
        curr.setHrsSistema(c.getHrsSistema());
        return clienteRepository.save(curr);
    }
}
