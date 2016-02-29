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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "rez_mo_prim")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RezMoPrim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "prim")
    private String prim;
    @JoinColumn(name = "rez_mo_vlozh_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RezMoVlozh rezMoVlozhId;

    public RezMoPrim() {
    }

    public RezMoPrim(Long id) {
        this.id = id;
    }

    public RezMoPrim(Long id, String prim) {
        this.id = id;
        this.prim = prim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    public RezMoVlozh getRezMoVlozhId() {
        return rezMoVlozhId;
    }

    public void setRezMoVlozhId(RezMoVlozh rezMoVlozhId) {
        this.rezMoVlozhId = rezMoVlozhId;
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
        if (!(object instanceof RezMoPrim)) {
            return false;
        }
        RezMoPrim other = (RezMoPrim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.RezMoPrim[ id=" + id + " ]";
    }
    
}
