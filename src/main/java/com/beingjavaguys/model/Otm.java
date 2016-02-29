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

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "otm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Otm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kl")
    private int kl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m")
    private boolean m;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public Otm() {
    }

    public Otm(Integer id) {
        this.id = id;
    }

    public Otm(Integer id, int kl, boolean m, int idUser) {
        this.id = id;
        this.kl = kl;
        this.m = m;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKl() {
        return kl;
    }

    public void setKl(int kl) {
        this.kl = kl;
    }

    public boolean getM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Otm)) {
            return false;
        }
        Otm other = (Otm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Otm[ id=" + id + " ]";
    }
    
}
