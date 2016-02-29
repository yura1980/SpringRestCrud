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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "my_password")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MyPassword  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pole1")
    private String pole1;
    @Size(max = 50)
    @Column(name = "pole2")
    private String pole2;
    @Column(name = "fv")
    private Integer fv;
    @Column(name = "reg")
    private Integer reg;
    @Column(name = "fp")
    private Integer fp;
    @Column(name = "id_vr")
    private Integer idVr;
    @Column(name = "tip")
    private Integer tip;
    @Size(max = 250)
    @Column(name = "info")
    private String info;

    public MyPassword() {
    }

    /*public MyPassword(Integer id) {
        this.id = id;
    }

    public MyPassword(Integer id, String pole1) {
        this.id = id;
        this.pole1 = pole1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getPole1() {
        return pole1;
    }

    public void setPole1(String pole1) {
        this.pole1 = pole1;
    }

    public String getPole2() {
        return pole2;
    }

    public void setPole2(String pole2) {
        this.pole2 = pole2;
    }

    public Integer getFv() {
        return fv;
    }

    public void setFv(Integer fv) {
        this.fv = fv;
    }

    public Integer getReg() {
        return reg;
    }

    public void setReg(Integer reg) {
        this.reg = reg;
    }

    public Integer getFp() {
        return fp;
    }

    public void setFp(Integer fp) {
        this.fp = fp;
    }

    public Integer getIdVr() {
        return idVr;
    }

    public void setIdVr(Integer idVr) {
        this.idVr = idVr;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        if (!(object instanceof MyPassword)) {
            return false;
        }
        MyPassword other = (MyPassword) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + id + " ]";
    }*/
    
}
