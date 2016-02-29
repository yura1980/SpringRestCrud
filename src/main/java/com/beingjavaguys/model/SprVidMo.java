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
@Table(name = "spr_vid_mo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprVidMo  extends Spr {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vid_mo")
    private String vidMo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sokr")
    private String sokr;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprVidMoId")
//    private Collection<Poseshenie> poseshenieCollection;

    public SprVidMo() {
    }

    /*public SprVidMo(Integer id) {
        this.id = id;
    }

    public SprVidMo(Integer id, String vidMo, String sokr) {
        this.id = id;
        this.vidMo = vidMo;
        this.sokr = sokr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getVidMo() {
        return vidMo;
    }

    public void setVidMo(String vidMo) {
        this.vidMo = vidMo;
    }

    public String getSokr() {
        return sokr;
    }

    public void setSokr(String sokr) {
        this.sokr = sokr;
    }

//    public Collection<Poseshenie> getPoseshenieCollection() {
//        return poseshenieCollection;
//    }
//
//    public void setPoseshenieCollection(Collection<Poseshenie> poseshenieCollection) {
//        this.poseshenieCollection = poseshenieCollection;
//    }

   /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprVidMo)) {
            return false;
        }
        SprVidMo other = (SprVidMo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SprVidMo[ id=" + id + " ]";
    }*/
    
}
