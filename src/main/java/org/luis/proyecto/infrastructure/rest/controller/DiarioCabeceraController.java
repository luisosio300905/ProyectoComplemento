package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.diariocabecera.DiarioCabeceraService;
import org.luis.proyecto.application.service.diariodetalle.DiarioDetalleService;
import org.luis.proyecto.infrastructure.mapper.DiarioCabeceraMapper;
import org.luis.proyecto.infrastructure.rest.request.DiarioCabeceraRequest;
import org.luis.proyecto.infrastructure.rest.response.DiarioCabeceraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diario-cabecera")
public class DiarioCabeceraController {
    private final DiarioCabeceraService diarioCabeceraService;
    private final DiarioDetalleService diarioDetalleService;
    private final DiarioCabeceraMapper diarioCabeceraMapper;

    public DiarioCabeceraController(DiarioCabeceraService diarioCabeceraService, 
                                    DiarioDetalleService diarioDetalleService, 
                                    DiarioCabeceraMapper diarioCabeceraMapper) {
        this.diarioCabeceraService = diarioCabeceraService;
        this.diarioDetalleService = diarioDetalleService;
        this.diarioCabeceraMapper = diarioCabeceraMapper;
    }

    @GetMapping("/ple/{ano}/{mes}")
    public ResponseEntity<byte[]> exportarPle(@PathVariable Integer ano, @PathVariable Integer mes) {
        List<org.luis.proyecto.domain.model.DiarioCabecera> cabeceras = diarioCabeceraService.obtenerPorAnoYMes(ano, mes);
        
        StringBuilder sb = new StringBuilder();
        int correlativoGeneral = 1;
        
        for (org.luis.proyecto.domain.model.DiarioCabecera cab : cabeceras) {
            List<org.luis.proyecto.domain.model.DiarioDetalle> detalles = diarioDetalleService.obtenerPorDiaCabCompId(cab.getDiaCabCompId());
            String fechaContab = cab.getDiaCabFec() != null
                    ? cab.getDiaCabFec().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
                    : "";
            
            for (org.luis.proyecto.domain.model.DiarioDetalle det : detalles) {
                sb.append(String.format("%04d%02d00", ano, mes)).append("|");
                sb.append("V").append(cab.getDiaCabCompId()).append("|");
                sb.append(String.format("M%04d", correlativoGeneral++)).append("|");
                String cuentaCompleta = det.getSubCtaId() != null ? det.getSubCtaId() : det.getCuentaId();
                if (cuentaCompleta == null) {
                    cuentaCompleta = "1011";
                }
                sb.append(cuentaCompleta).append("|");
                sb.append("|");
                sb.append("|");
                sb.append("PEN").append("|");
                sb.append("|");
                sb.append("|");
                String docNum = det.getDiaDetNumDoc();
                String tipoComp = "01";
                if (docNum != null && docNum.startsWith("B")) {
                    tipoComp = "03";
                }
                sb.append(tipoComp).append("|");
                String serie = "";
                String numero = "";
                if (docNum != null && docNum.contains("-")) {
                    String[] parts = docNum.split("-");
                    if (parts.length > 0) serie = parts[0];
                    if (parts.length > 1) numero = parts[1];
                } else if (docNum != null) {
                    numero = docNum;
                }
                sb.append(serie).append("|");
                sb.append(numero).append("|");
                sb.append(fechaContab).append("|");
                sb.append("|");
                sb.append(fechaContab).append("|");
                
                String glosa = det.getDiaDetTexOpe() != null ? det.getDiaDetTexOpe() : cab.getDiaCabGlosa();
                if (glosa == null) glosa = "Asiento contable";
                sb.append(glosa).append("|");
                
                sb.append("|");
                
                java.math.BigDecimal debe = det.getDiaDetDebe() != null ? det.getDiaDetDebe() : java.math.BigDecimal.ZERO;
                sb.append(debe.setScale(2, java.math.RoundingMode.HALF_UP)).append("|");
                
                java.math.BigDecimal haber = det.getDiaDetHaber() != null ? det.getDiaDetHaber() : java.math.BigDecimal.ZERO;
                sb.append(haber.setScale(2, java.math.RoundingMode.HALF_UP)).append("|");
                
                sb.append("1").append("|\r\n");
            }
        }
        
        String ruc = "20601234567";
        String filename = String.format("LE%s%04d%02d00050100001111.txt", ruc, ano, mes);
        
        byte[] data = sb.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
        headers.setContentDisposition(org.springframework.http.ContentDisposition.attachment().filename(filename).build());
        
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<DiarioCabeceraResponse>> obtenerTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponseList(diarioCabeceraService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<DiarioCabeceraResponse> crear(@RequestBody DiarioCabeceraRequest diarioCabeceraRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(
                        diarioCabeceraService.crear(diarioCabeceraMapper.toDiarioCabecera(diarioCabeceraRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarioCabeceraResponse> obtenerById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(diarioCabeceraService.obtenerById(id)));
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<DiarioCabeceraResponse> obtenerByEmpresaId(@PathVariable String empresaId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(diarioCabeceraService.obtenerByEmpresaId(empresaId)));
    }

    @GetMapping("/periodo/{ano}/{mes}")
    public ResponseEntity<List<DiarioCabeceraResponse>> obtenerPorAnoYMes(@PathVariable Integer ano, @PathVariable Integer mes) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponseList(diarioCabeceraService.obtenerPorAnoYMes(ano, mes)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiarioCabeceraResponse> actualizar(@PathVariable Long id, @RequestBody DiarioCabeceraRequest diarioCabeceraRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(
                        diarioCabeceraService.actualizar(id, diarioCabeceraMapper.toDiarioCabecera(diarioCabeceraRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        diarioCabeceraService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

