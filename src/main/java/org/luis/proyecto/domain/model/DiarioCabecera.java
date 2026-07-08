package org.luis.proyecto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiarioCabecera {
    private Long diaCabCompId;
    private Integer diaCabAno;
    private Integer diaCabMes;
    private String empresaId;
    private LocalDateTime diaCabFec;
    private String diaCabGlosa;
    private String diaCabAccImp;
    private String diaCabAccEdi;
    private Integer subMovId;
    private Integer movConId;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private List<DiarioDetalle> detalles;

    // Constructor vacío
    public DiarioCabecera() {
        this.detalles = new ArrayList<>();
    }

    // Método para agregar un detalle a la cabecera
    public DiarioDetalle agregarDetalle(BigDecimal monto, String tipoCuenta, String descripcion, String cuentaId, String subCtaId, String monedaId, String usuario) {
        DiarioDetalle detalle = new DiarioDetalle();
        detalle.setDiaCabCompId(this.diaCabCompId);
        detalle.setCuentaId(cuentaId);
        detalle.setSubCtaId(subCtaId);
        detalle.setMonedaId(monedaId);
        detalle.setUsrSistema(usuario);
        detalle.setFecSistema(LocalDateTime.now());
        
        if ("DEBE".equalsIgnoreCase(tipoCuenta)) {
            detalle.setDiaDetDebe(monto != null ? monto : BigDecimal.ZERO);
            detalle.setDiaDetHaber(BigDecimal.ZERO);
        } else if ("HABER".equalsIgnoreCase(tipoCuenta)) {
            detalle.setDiaDetDebe(BigDecimal.ZERO);
            detalle.setDiaDetHaber(monto != null ? monto : BigDecimal.ZERO);
        }
        
        detalle.setDiaDetTexOpe(descripcion);
        this.detalles.add(detalle);
        return detalle;
    }

    // Getters y Setters
    public Long getDiaCabCompId() { return diaCabCompId; }
    public void setDiaCabCompId(Long diaCabCompId) { this.diaCabCompId = diaCabCompId; }

    public Integer getDiaCabAno() { return diaCabAno; }
    public void setDiaCabAno(Integer diaCabAno) { this.diaCabAno = diaCabAno; }

    public Integer getDiaCabMes() { return diaCabMes; }
    public void setDiaCabMes(Integer diaCabMes) { this.diaCabMes = diaCabMes; }

    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }

    public LocalDateTime getDiaCabFec() { return diaCabFec; }
    public void setDiaCabFec(LocalDateTime diaCabFec) { this.diaCabFec = diaCabFec; }

    public String getDiaCabGlosa() { return diaCabGlosa; }
    public void setDiaCabGlosa(String diaCabGlosa) { this.diaCabGlosa = diaCabGlosa; }

    public String getDiaCabAccImp() { return diaCabAccImp; }
    public void setDiaCabAccImp(String diaCabAccImp) { this.diaCabAccImp = diaCabAccImp; }

    public String getDiaCabAccEdi() { return diaCabAccEdi; }
    public void setDiaCabAccEdi(String diaCabAccEdi) { this.diaCabAccEdi = diaCabAccEdi; }

    public Integer getSubMovId() { return subMovId; }
    public void setSubMovId(Integer subMovId) { this.subMovId = subMovId; }

    public Integer getMovConId() { return movConId; }
    public void setMovConId(Integer movConId) { this.movConId = movConId; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public List<DiarioDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<DiarioDetalle> detalles) { this.detalles = detalles; }
}

