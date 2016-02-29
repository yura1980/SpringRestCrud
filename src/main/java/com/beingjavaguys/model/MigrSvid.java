/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "migr_svid")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MigrSvid implements Serializable {

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
    @Column(name = "fio_vr")
    private Integer fioVr;
    @Size(max = 2)
    @Column(name = "ser")
    private String ser;
    @Size(max = 10)
    @Column(name = "nom")
    private String nom;
    @Column(name = "dt")
    @Temporal(TemporalType.DATE)
    private Date dt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vid")
    private boolean vid;
    @Column(name = "l_count")
    private Integer lCount;

    public MigrSvid() {
    }

    public MigrSvid(Integer id) {
        this.id = id;
    }

    public MigrSvid(Integer id, int kl, boolean vid) {
        this.id = id;
        this.kl = kl;
        this.vid = vid;
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

    public Integer getFioVr() {
        return fioVr;
    }

    public void setFioVr(Integer fioVr) {
        this.fioVr = fioVr;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public boolean getVid() {
        return vid;
    }

    public void setVid(boolean vid) {
        this.vid = vid;
    }

    public Integer getLCount() {
        return lCount;
    }

    public void setLCount(Integer lCount) {
        this.lCount = lCount;
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
        if (!(object instanceof MigrSvid)) {
            return false;
        }
        MigrSvid other = (MigrSvid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MigrSvid[ id=" + id + " ]";
    }
    
}
