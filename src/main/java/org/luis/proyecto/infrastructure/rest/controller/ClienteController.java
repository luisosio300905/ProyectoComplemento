package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.cliente.ClienteService;
import org.luis.proyecto.infrastructure.mapper.ClienteMapper;
import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ClienteResponse>> getClientes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteMapper.toClienteResponseList(clienteService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteMapper.toClienteResponse(
                        clienteService.crear(clienteMapper.toCliente(clienteRequest))
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteMapper.toClienteResponse(
                        clienteService.obtenerCliente(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> updateCliente(@PathVariable Integer id,
                                                         @RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteMapper.toClienteResponse(
                        clienteService.actualizar(id, clienteMapper.toCliente(clienteRequest))
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
