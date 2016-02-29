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
 *
 * @author yuri
 */
@Entity
@Table(name = "rez_lom_diagn")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RezLomDiagn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_giag")
    private int numGiag;
    @JoinColumn(name = "rez_lom_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RezLom rezLomId;

    public RezLomDiagn() {
    }

    public RezLomDiagn(Long id) {
        this.id = id;
    }

    public RezLomDiagn(Long id, int numGiag) {
        this.id = id;
        this.numGiag = numGiag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumGiag() {
        return numGiag;
    }

    public void setNumGiag(int numGiag) {
        this.numGiag = numGiag;
    }

    public RezLom getRezLomId() {
        return rezLomId;
    }

    public void setRezLomId(RezLom rezLomId) {
        this.rezLomId = rezLomId;
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
        if (!(object instanceof RezLomDiagn)) {
            return false;
        }
        RezLomDiagn other = (RezLomDiagn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.RezLomDiagn[ id=" + id + " ]";
    }
    
}
