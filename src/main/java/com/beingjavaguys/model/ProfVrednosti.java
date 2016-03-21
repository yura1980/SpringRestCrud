/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author yuri
 */
@Entity
@Table(name = "prof_vrednosti")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProfVrednosti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //    @Basic(optional = false)
//    @NotNull
//    @Column(name = "idpril")
//    private int idpril;
    @JoinColumn(name = "idpril", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProfvrednostPrilozh idpril;
    //    @JoinColumn(name = "poseshenie_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private Poseshenie poseshenieId;
    @NotNull
    @Column(name = "poseshenie_id")
    private long poseshenieId;

    public ProfVrednosti() {
    }

    public ProfVrednosti(Integer id) {
        this.id = id;
    }

    public ProfVrednosti(long poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

    public ProfVrednosti(long poseshenieId, ProfvrednostPrilozh idpril) {
        this.poseshenieId = poseshenieId;
        this.idpril = idpril;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfvrednostPrilozh getIdpril() {
        return idpril;
    }

    public void setIdpril(ProfvrednostPrilozh idpril) {
        this.idpril = idpril;
    }

    public long getPoseshenieId() {
        return poseshenieId;
    }

    public void setPoseshenieId(long poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfVrednosti)) {
            return false;
        }
        ProfVrednosti other = (ProfVrednosti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfVrednosti[ id=" + id + " ]";
    }

}
