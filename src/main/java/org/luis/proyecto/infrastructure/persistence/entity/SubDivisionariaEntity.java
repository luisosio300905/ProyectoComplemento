package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SubDivisionaria")
@IdClass(SubDivisionariaPK.class)
public class SubDivisionariaEntity {
    @Id
    @Column(name = "CuentaId")
    private String cuentaId;

    @Id
    @Column(name = "SubCtaId")
    private String subCtaId;

    @Id
    @Column(name = "DivisioId")
    private String divisioId;

    @Id
    @Column(name = "SubDivId")
    private String subDivId;

    @Column(name = "SubDivDescripcion")
    private String subDivDescripcion;

    @Column(name = "SubDivCenCost")
    private Boolean subDivCenCost;

    @Column(name = "SubDivCtaCte")
    private Boolean subDivCtaCte;

    @Column(name = "SubDivAnalisis")
    private Boolean subDivAnalisis;

    @Column(name = "SubDivEstado")
    private Boolean subDivEstado;

    @Column(name = "TipCtaId")
    private Integer tipCtaId;

    @Column(name = "SubDivNumDigSunat")
    private Integer subDivNumDigSunat;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @Column(name = "cta5")
    private String cta5;

    @Column(name = "cta8")
    private String cta8;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CuentaId", insertable = false, updatable = false),
        @JoinColumn(name = "SubCtaId", insertable = false, updatable = false),
        @JoinColumn(name = "DivisioId", insertable = false, updatable = false)
    })
    private DivisionariaEntity divisionaria;

    public SubDivisionariaEntity() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getDivisioId() { return divisioId; }
    public void setDivisioId(String divisioId) { this.divisioId = divisioId; }

    public String getSubDivId() { return subDivId; }
    public void setSubDivId(String subDivId) { this.subDivId = subDivId; }

    public String getSubDivDescripcion() { return subDivDescripcion; }
    public void setSubDivDescripcion(String subDivDescripcion) { this.subDivDescripcion = subDivDescripcion; }

    public Boolean getSubDivCenCost() { return subDivCenCost; }
    public void setSubDivCenCost(Boolean subDivCenCost) { this.subDivCenCost = subDivCenCost; }

    public Boolean getSubDivCtaCte() { return subDivCtaCte; }
    public void setSubDivCtaCte(Boolean subDivCtaCte) { this.subDivCtaCte = subDivCtaCte; }

    public Boolean getSubDivAnalisis() { return subDivAnalisis; }
    public void setSubDivAnalisis(Boolean subDivAnalisis) { this.subDivAnalisis = subDivAnalisis; }

    public Boolean getSubDivEstado() { return subDivEstado; }
    public void setSubDivEstado(Boolean subDivEstado) { this.subDivEstado = subDivEstado; }

    public Integer getTipCtaId() { return tipCtaId; }
    public void setTipCtaId(Integer tipCtaId) { this.tipCtaId = tipCtaId; }

    public Integer getSubDivNumDigSunat() { return subDivNumDigSunat; }
    public void setSubDivNumDigSunat(Integer subDivNumDigSunat) { this.subDivNumDigSunat = subDivNumDigSunat; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public String getCta5() { return cta5; }
    public void setCta5(String cta5) { this.cta5 = cta5; }

    public String getCta8() { return cta8; }
    public void setCta8(String cta8) { this.cta8 = cta8; }

    public DivisionariaEntity getDivisionaria() { return divisionaria; }
    public void setDivisionaria(DivisionariaEntity divisionaria) { this.divisionaria = divisionaria; }
}

