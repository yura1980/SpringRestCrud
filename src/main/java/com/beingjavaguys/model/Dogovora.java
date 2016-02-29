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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "dogovora")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dogovora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spisok_lpmo_kl")
    private Integer spisokLpmoKl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomerdog")
    private int nomerdog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip")
    private int tip;
    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Poseshenie poseshenie;

    public Dogovora() {
    }

    public Dogovora(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public Dogovora(Integer spisokLpmoKl, int nomerdog, int tip) {
        this.spisokLpmoKl = spisokLpmoKl;
        this.nomerdog = nomerdog;
        this.tip = tip;
    }

    public Integer getSpisokLpmoKl() {
        return spisokLpmoKl;
    }

    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public int getNomerdog() {
        return nomerdog;
    }

    public void setNomerdog(int nomerdog) {
        this.nomerdog = nomerdog;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public Poseshenie getPoseshenie() {
        return poseshenie;
    }

    public void setPoseshenie(Poseshenie poseshenie) {
        this.poseshenie = poseshenie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spisokLpmoKl != null ? spisokLpmoKl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dogovora)) {
            return false;
        }
        Dogovora other = (Dogovora) object;
        if ((this.spisokLpmoKl == null && other.spisokLpmoKl != null) || (this.spisokLpmoKl != null && !this.spisokLpmoKl.equals(other.spisokLpmoKl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Dogovora[ spisokLpmoKl=" + spisokLpmoKl + " ]";
    }
    
}
