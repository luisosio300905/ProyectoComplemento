package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Divisionaria")
@IdClass(DivisionariaPK.class)
public class DivisionariaEntity {
    @Id
    @Column(name = "CuentaId")
    private String cuentaId;

    @Id
    @Column(name = "SubCtaId")
    private String subCtaId;

    @Id
    @Column(name = "DivisioId")
    private String divisioId;

    @Column(name = "DivisioDescripcion")
    private String divisioDescripcion;

    @Column(name = "DivisioEstad")
    private Boolean divisioEstad;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CuentaId", insertable = false, updatable = false),
        @JoinColumn(name = "SubCtaId", insertable = false, updatable = false)
    })
    private SubCuentaEntity subCuenta;

    @OneToMany(mappedBy = "divisionaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubDivisionariaEntity> subDivisionarias;

    public DivisionariaEntity() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getDivisioDescripcion() { return divisioDescripcion; }
    public void setDivisioDescripcion(String divisioDescripcion) { this.divisioDescripcion = divisioDescripcion; }

    public Boolean getDivisioEstad() { return divisioEstad; }
    public void setDivisioEstad(Boolean divisioEstad) { this.divisioEstad = divisioEstad; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public SubCuentaEntity getSubCuenta() { return subCuenta; }
    public void setSubCuenta(SubCuentaEntity subCuenta) { this.subCuenta = subCuenta; }

    public List<SubDivisionariaEntity> getSubDivisionarias() { return subDivisionarias; }
    public void setSubDivisionarias(List<SubDivisionariaEntity> subDivisionarias) { this.subDivisionarias = subDivisionarias; }
}

