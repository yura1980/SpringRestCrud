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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "shabl_vr_iss_rek")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShablVrIssRek  extends Spr  {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shabl")
    private String shabl;
    @Column(name = "id_vir")
    private Integer idVir;
    @Column(name = "tip")
    private Integer tip;

    public ShablVrIssRek() {
    }

//    public ShablVrIssRek(Integer id) {
//        this.id = id;
//    }
//
//    public ShablVrIssRek(Integer id, String shabl) {
//        this.id = id;
//        this.shabl = shabl;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getShabl() {
        return shabl;
    }

    public void setShabl(String shabl) {
        this.shabl = shabl;
    }

    public Integer getIdVir() {
        return idVir;
    }

    public void setIdVir(Integer idVir) {
        this.idVir = idVir;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ShablVrIssRek)) {
//            return false;
//        }
//        ShablVrIssRek other = (ShablVrIssRek) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "ShablVrIssRek[ id=" + id + " ]";
//    }
    
}
