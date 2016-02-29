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
@Table(name = "spr_raion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprRaion  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "raion")
    private String raion;
//    @OneToMany(mappedBy = "sprRaionId")
//    private Collection<Adres> adresCollection;

    public SprRaion() {
    }

    public SprRaion(/*Integer id, */String raion) {
//        this.id = id;
        this.raion = raion;
    }
    /*public SprRaion(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getRaion() {
        return raion;
    }

    public void setRaion(String raion) {
        this.raion = raion;
    }

//    public Collection<Adres> getAdresCollection() {
//        return adresCollection;
//    }
//
//    public void setAdresCollection(Collection<Adres> adresCollection) {
//        this.adresCollection = adresCollection;
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
        if (!(object instanceof SprRaion)) {
            return false;
        }
        SprRaion other = (SprRaion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprRaion[ id=" + id + " ]";
    }*/
    
}
