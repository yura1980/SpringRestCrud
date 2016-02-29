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
@Table(name = "spr_zk_rek")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprZkRek  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "txt_res")
    private String txtRes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zakl")
    private boolean zakl;
    @OneToMany(mappedBy = "rezultatMo")
    private Collection<RezMoVlozh> rezMoVlozhCollection;

    public SprZkRek() {
    }

    /*public SprZkRek(Integer id) {
        this.id = id;
    }

    public SprZkRek(Integer id, String txtRes, boolean zakl) {
        this.id = id;
        this.txtRes = txtRes;
        this.zakl = zakl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getTxtRes() {
        return txtRes;
    }

    public void setTxtRes(String txtRes) {
        this.txtRes = txtRes;
    }

    public boolean getZakl() {
        return zakl;
    }

    public void setZakl(boolean zakl) {
        this.zakl = zakl;
    }

    public Collection<RezMoVlozh> getRezMoVlozhCollection() {
        return rezMoVlozhCollection;
    }

    public void setRezMoVlozhCollection(Collection<RezMoVlozh> rezMoVlozhCollection) {
        this.rezMoVlozhCollection = rezMoVlozhCollection;
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
        if (!(object instanceof SprZkRek)) {
            return false;
        }
        SprZkRek other = (SprZkRek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprZkRek[ id=" + id + " ]";
    }*/
    
}
