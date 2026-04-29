package org.luis.proyecto.infrastructure.rest;

import org.luis.proyecto.application.service.cliente.ClienteService;
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

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClienteResponse>> getClientes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteService.obtenerTodos());
    }

    @PostMapping("")
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteService.crear(clienteRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteService.obtenerCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> updateCliente(@PathVariable Integer id,
                                                         @RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteService.actualizar(id, clienteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
