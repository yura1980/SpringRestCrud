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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_org")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprOrg extends Spr {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_org")
    private String nameOrg;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sprOrg")
    private SprOrgDopInf sprOrgDopInf;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprOrgId")
//    private Collection<Rabota> rabotaCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprOrgId")
//    private Collection<Jurnal> jurnalCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sprOrg")
    private CenyMoOrg cenyMoOrg;

    public SprOrg() {
    }

    public SprOrg(/*Integer id,*/ String nameOrg) {
//        this.id = id;
        this.nameOrg = nameOrg;
    }
    /*public SprOrg(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getNameOrg() {
        return nameOrg;
    }

    public void setNameOrg(String nameOrg) {
        this.nameOrg = nameOrg;
    }

    public SprOrgDopInf getSprOrgDopInf() {
        return sprOrgDopInf;
    }

    public void setSprOrgDopInf(SprOrgDopInf sprOrgDopInf) {
        this.sprOrgDopInf = sprOrgDopInf;
    }
//
//    public Collection<Rabota> getRabotaCollection() {
//        return rabotaCollection;
//    }
//
//    public void setRabotaCollection(Collection<Rabota> rabotaCollection) {
//        this.rabotaCollection = rabotaCollection;
//    }
//
//    public Collection<Jurnal> getJurnalCollection() {
//        return jurnalCollection;
//    }
//
//    public void setJurnalCollection(Collection<Jurnal> jurnalCollection) {
//        this.jurnalCollection = jurnalCollection;
//    }
//
    public CenyMoOrg getCenyMoOrg() {
        return cenyMoOrg;
    }

    public void setCenyMoOrg(CenyMoOrg cenyMoOrg) {
        this.cenyMoOrg = cenyMoOrg;
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
        if (!(object instanceof SprOrg)) {
            return false;
        }
        SprOrg other = (SprOrg) object;
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
