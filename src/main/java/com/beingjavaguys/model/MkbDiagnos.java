package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "mkb_diagnos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MkbDiagnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diag")
    private Integer idDiag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "diag")
    private String diag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "n_diag")
    private String nDiag;
    @Column(name = "id_class")
    private Integer idClass;
    @Column(name = "p")
    private Integer p;

    public MkbDiagnos() {
    }

    public MkbDiagnos(Integer idDiag) {
        this.idDiag = idDiag;
    }

    public MkbDiagnos(Integer idDiag, String diag, String nDiag) {
        this.idDiag = idDiag;
        this.diag = diag;
        this.nDiag = nDiag;
    }

    public Integer getIdDiag() {
        return idDiag;
    }

    public void setIdDiag(Integer idDiag) {
        this.idDiag = idDiag;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public String getNDiag() {
        return nDiag;
    }

    public void setNDiag(String nDiag) {
        this.nDiag = nDiag;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiag != null ? idDiag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbDiagnos)) {
            return false;
        }
        MkbDiagnos other = (MkbDiagnos) object;
        if ((this.idDiag == null && other.idDiag != null) || (this.idDiag != null && !this.idDiag.equals(other.idDiag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[idDiag=" + idDiag + "]";
    }
    
}
