package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ComprobantePago")
public class ComprobantePagoEntity {
    @Id
    @Column(name = "ComPagId", length = 50)
    private String id;

    @Column(name = "ComPagDescripcion")
    private String comPagDescripcion;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @OneToMany(mappedBy = "comprobantePago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DocumentoEntity> documentos;

    public ComprobantePagoEntity() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getComPagDescripcion() { return comPagDescripcion; }
    public void setComPagDescripcion(String comPagDescripcion) { this.comPagDescripcion = comPagDescripcion; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
    public List<DocumentoEntity> getDocumentos() { return documentos; }
    public void setDocumentos(List<DocumentoEntity> documentos) { this.documentos = documentos; }
}
