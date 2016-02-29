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
@Table(name = "zapisi_priema")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ZapisiPriema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;
    @Column(name = "vrem")
    @Temporal(TemporalType.TIME)
    private Date vrem;
    @Column(name = "vr")
    private Integer vr;
    @Column(name = "iss")
    private Integer iss;
    @Size(max = 450)
    @Column(name = "komm")
    private String komm;
    @Size(max = 15)
    @Column(name = "tel")
    private String tel;
    @Size(max = 10)
    @Column(name = "kab")
    private String kab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fam")
    private int fam;
    @Column(name = "ima")
    private Integer ima;
    @Column(name = "otch")
    private Integer otch;

    public ZapisiPriema() {
    }

    public ZapisiPriema(Integer id) {
        this.id = id;
    }

    public ZapisiPriema(Integer id, Date dt, int fam) {
        this.id = id;
        this.dt = dt;
        this.fam = fam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Date getVrem() {
        return vrem;
    }

    public void setVrem(Date vrem) {
        this.vrem = vrem;
    }

    public Integer getVr() {
        return vr;
    }

    public void setVr(Integer vr) {
        this.vr = vr;
    }

    public Integer getIss() {
        return iss;
    }

    public void setIss(Integer iss) {
        this.iss = iss;
    }

    public String getKomm() {
        return komm;
    }

    public void setKomm(String komm) {
        this.komm = komm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public int getFam() {
        return fam;
    }

    public void setFam(int fam) {
        this.fam = fam;
    }

    public Integer getIma() {
        return ima;
    }

    public void setIma(Integer ima) {
        this.ima = ima;
    }

    public Integer getOtch() {
        return otch;
    }

    public void setOtch(Integer otch) {
        this.otch = otch;
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
        if (!(object instanceof ZapisiPriema)) {
            return false;
        }
        ZapisiPriema other = (ZapisiPriema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.ZapisiPriema[ id=" + id + " ]";
    }
    
}
