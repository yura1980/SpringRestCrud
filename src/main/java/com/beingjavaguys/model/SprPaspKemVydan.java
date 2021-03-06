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
@Table(name = "spr_pasp_kem_vydan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprPaspKemVydan  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "kem_vydan")
    private String kemVydan;
//    @OneToMany(mappedBy = "sprPaspKemVydanId")
//    private Collection<Pasporta> pasportaCollection;

    public SprPaspKemVydan() {
    }

    public SprPaspKemVydan(/*Integer id, */String kemVydan) {
//        this.id = id;
        this.kemVydan = kemVydan;
    }
    /*public SprPaspKemVydan(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getKemVydan() {
        return kemVydan;
    }

    public void setKemVydan(String kemVydan) {
        this.kemVydan = kemVydan;
    }

//    public Collection<Pasporta> getPasportaCollection() {
//        return pasportaCollection;
//    }
//
//    public void setPasportaCollection(Collection<Pasporta> pasportaCollection) {
//        this.pasportaCollection = pasportaCollection;
//    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprPaspKemVydan)) {
            return false;
        }
        SprPaspKemVydan other = (SprPaspKemVydan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprPaspKemVydan[ id=" + id + " ]";
    }*/
    
}
