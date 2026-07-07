package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DiarioCabecera")
public class DiarioCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiaCabCompId")
    private Long diaCabCompId;

    @Column(name = "DiaCabAno")
    private Integer diaCabAno;

    @Column(name = "DiaCabMes")
    private Integer diaCabMes;

    @Column(name = "EmpresaId")
    private String empresaId;

    @Column(name = "DiaCabFec")
    private LocalDateTime diaCabFec;

    @Column(name = "DiaCabGlosa", columnDefinition = "TEXT")
    private String diaCabGlosa;

    @Column(name = "DiaCabAccImp")
    private String diaCabAccImp;

    @Column(name = "DiaCabAccEdi")
    private String diaCabAccEdi;

    @Column(name = "SubMovId")
    private Integer subMovId;

    @Column(name = "MovConId")
    private Integer movConId;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @OneToMany(mappedBy = "diarioCabecera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiarioDetalleEntity> detalles;

    // Constructor vacío
    public DiarioCabeceraEntity() {}

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

    public List<DiarioDetalleEntity> getDetalles() { return detalles; }
    public void setDetalles(List<DiarioDetalleEntity> detalles) { this.detalles = detalles; }
}

