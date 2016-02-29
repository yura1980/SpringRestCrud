/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "rez_lom")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RezLom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezLomId")
    private Collection<RezLomDiagn> rezLomDiagnCollection;
    @JoinColumn(name = "rezultat_mo_poseshenie_id", referencedColumnName = "poseshenie_id")
    @ManyToOne(optional = false)
    private RezultatMo rezultatMoPoseshenieId;
    @JoinColumn(name = "spr_lom_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprLom sprLomId;
    @JoinColumn(name = "prifil_id", referencedColumnName = "id")
    @ManyToOne
    private SprProfil prifilId;

    public RezLom() {
    }

    public RezLom(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<RezLomDiagn> getRezLomDiagnCollection() {
        return rezLomDiagnCollection;
    }

    public void setRezLomDiagnCollection(Collection<RezLomDiagn> rezLomDiagnCollection) {
        this.rezLomDiagnCollection = rezLomDiagnCollection;
    }

    public RezultatMo getRezultatMoPoseshenieId() {
        return rezultatMoPoseshenieId;
    }

    public void setRezultatMoPoseshenieId(RezultatMo rezultatMoPoseshenieId) {
        this.rezultatMoPoseshenieId = rezultatMoPoseshenieId;
    }

    public SprLom getSprLomId() {
        return sprLomId;
    }

    public void setSprLomId(SprLom sprLomId) {
        this.sprLomId = sprLomId;
    }

    public SprProfil getPrifilId() {
        return prifilId;
    }

    public void setPrifilId(SprProfil prifilId) {
        this.prifilId = prifilId;
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
        if (!(object instanceof RezLom)) {
            return false;
        }
        RezLom other = (RezLom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.RezLom[ id=" + id + " ]";
    }
    
}
