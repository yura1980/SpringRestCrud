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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_polikliniki")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprPolikliniki extends Spr {

    private static final long serialVersionUID = 1L;
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "poliklinika")
    private String poliklinika;
    @Column(name = "id_r")
    private Integer idR;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprPoliklinikiId")
//    private Collection<Jurnal> jurnalCollection;
    @JoinColumn(name = "spr_tip_polikliniki_id", referencedColumnName = "id")
    @ManyToOne
    private SprTipPolikliniki sprTipPoliklinikiId;

    public SprPolikliniki() {
    }

    public SprPolikliniki(/*Integer id, */String poliklinika) {
//        this.id = id;
        this.poliklinika = poliklinika;
    }
   /* public SprPolikliniki(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getPoliklinika() {
        return poliklinika;
    }

    public void setPoliklinika(String poliklinika) {
        this.poliklinika = poliklinika;
    }

    public Integer getIdR() {
        return idR;
    }

    public void setIdR(Integer idR) {
        this.idR = idR;
    }
//
//    public Collection<Jurnal> getJurnalCollection() {
//        return jurnalCollection;
//    }
//
//    public void setJurnalCollection(Collection<Jurnal> jurnalCollection) {
//        this.jurnalCollection = jurnalCollection;
//    }
////
    public SprTipPolikliniki getSprTipPoliklinikiId() {
        return sprTipPoliklinikiId;
    }

    public void setSprTipPoliklinikiId(SprTipPolikliniki sprTipPoliklinikiId) {
        this.sprTipPoliklinikiId = sprTipPoliklinikiId;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprPolikliniki)) {
            return false;
        }
        SprPolikliniki other = (SprPolikliniki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }*/
    
}
