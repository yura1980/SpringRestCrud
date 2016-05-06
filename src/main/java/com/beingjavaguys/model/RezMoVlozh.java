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
@Table(name = "rez_mo_vlozh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RezMoVlozh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "vrach")
    private Integer vrach;
//    @JoinColumn(name = "rezultat_mo_poseshenie_id", referencedColumnName = "poseshenie_id")
//    @ManyToOne(optional = false)
    @Column(name = "rezultat_mo_poseshenie_id")
    private Long rezultatMoPoseshenieId;
    //private RezultatMo rezultatMoPoseshenieId;
    @JoinColumn(name = "rezultat_mo", referencedColumnName = "id")
    @ManyToOne
    private SprZkRek rezultatMo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezMoVlozhId")
//    private Collection<RezMoDiagn> rezMoDiagnCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezMoVlozhId")
//    private Collection<RezMoPrim> rezMoPrimCollection;

    public RezMoVlozh() {
    }

    public RezMoVlozh(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVrach() {
        return vrach;
    }

    public void setVrach(Integer vrach) {
        this.vrach = vrach;
    }

    public Long getRezultatMoPoseshenieId() {
        return rezultatMoPoseshenieId;
    }

    public void setRezultatMoPoseshenieId(Long rezultatMoPoseshenieId) {
        this.rezultatMoPoseshenieId = rezultatMoPoseshenieId;
    }

    public SprZkRek getRezultatMo() {
        return rezultatMo;
    }

    public void setRezultatMo(SprZkRek rezultatMo) {
        this.rezultatMo = rezultatMo;
    }

//    public Collection<RezMoDiagn> getRezMoDiagnCollection() {
//        return rezMoDiagnCollection;
//    }
//
//    public void setRezMoDiagnCollection(Collection<RezMoDiagn> rezMoDiagnCollection) {
//        this.rezMoDiagnCollection = rezMoDiagnCollection;
//    }
//
//    public Collection<RezMoPrim> getRezMoPrimCollection() {
//        return rezMoPrimCollection;
//    }
//
//    public void setRezMoPrimCollection(Collection<RezMoPrim> rezMoPrimCollection) {
//        this.rezMoPrimCollection = rezMoPrimCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RezMoVlozh)) {
            return false;
        }
        RezMoVlozh other = (RezMoVlozh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RezMoVlozh[ id=" + id + " ]";
    }
    
}
