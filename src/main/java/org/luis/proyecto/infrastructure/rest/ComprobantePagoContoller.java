    package org.luis.proyecto.infrastructure.rest;

    import org.luis.proyecto.application.service.comprobantepago.ComprobantePagoService;
    import org.luis.proyecto.infrastructure.mapper.ComprobantePagoMapper;
    import org.luis.proyecto.infrastructure.rest.request.ComprobantePagoRequest;
    import org.luis.proyecto.infrastructure.rest.response.ComprobantePagoResponse;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/comprobantepago")
    public class ComprobantePagoContoller {
        private final ComprobantePagoService comprobantePagoService;
        private final ComprobantePagoMapper comprobantePagoMapper;

        public ComprobantePagoContoller(ComprobantePagoService comprobantePagoService, ComprobantePagoMapper comprobantePagoMapper) {
            this.comprobantePagoService = comprobantePagoService;
            this.comprobantePagoMapper = comprobantePagoMapper;
        }

        @GetMapping("")
        public ResponseEntity<List<ComprobantePagoResponse>> getComprobantePagos() {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(comprobantePagoMapper.toComprobantePagoResponseList(comprobantePagoService.obtenerTodos()));
        }

        @PostMapping("")
        public ResponseEntity<ComprobantePagoResponse> createComprobantePago(@RequestBody ComprobantePagoRequest ComprobantePagoRequest) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(comprobantePagoMapper.toComprobantePagoResponse(
                            comprobantePagoService.crear(comprobantePagoMapper.toComprobantePago(ComprobantePagoRequest))));
        }

        @GetMapping("/{id}")
        public ResponseEntity<ComprobantePagoResponse> getComprobantePago(@PathVariable Integer id) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(comprobantePagoMapper.toComprobantePagoResponse(comprobantePagoService.obtenerComprobantePago(id)));
        }

        @PutMapping("/{id}")
        public ResponseEntity<ComprobantePagoResponse> updateComprobantePago(@PathVariable Integer id, @RequestBody ComprobantePagoRequest ComprobantePagoRequest) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(comprobantePagoMapper.toComprobantePagoResponse(
                            comprobantePagoService.actualizar(id, comprobantePagoMapper.toComprobantePago(ComprobantePagoRequest))));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
            comprobantePagoService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
