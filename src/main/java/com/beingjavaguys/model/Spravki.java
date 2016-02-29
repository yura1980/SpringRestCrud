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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "spravki")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Spravki implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpravkiPK spravkiPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "nomer")
    private String nomer;
    @Size(max = 15)
    @Column(name = "dop_info")
    private String dopInfo;
    @Column(name = "prich_poluch")
    private Integer prichPoluch;
    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Poseshenie poseshenie;

    public Spravki() {
    }

    public Spravki(SpravkiPK spravkiPK) {
        this.spravkiPK = spravkiPK;
    }

    public Spravki(SpravkiPK spravkiPK, String nomer) {
        this.spravkiPK = spravkiPK;
        this.nomer = nomer;
    }

    public Spravki(int spisokLpmoKl, int vidspravki) {
        this.spravkiPK = new SpravkiPK(spisokLpmoKl, vidspravki);
    }

    public SpravkiPK getSpravkiPK() {
        return spravkiPK;
    }

    public void setSpravkiPK(SpravkiPK spravkiPK) {
        this.spravkiPK = spravkiPK;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getDopInfo() {
        return dopInfo;
    }

    public void setDopInfo(String dopInfo) {
        this.dopInfo = dopInfo;
    }

    public Integer getPrichPoluch() {
        return prichPoluch;
    }

    public void setPrichPoluch(Integer prichPoluch) {
        this.prichPoluch = prichPoluch;
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
        hash += (spravkiPK != null ? spravkiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spravki)) {
            return false;
        }
        Spravki other = (Spravki) object;
        if ((this.spravkiPK == null && other.spravkiPK != null) || (this.spravkiPK != null && !this.spravkiPK.equals(other.spravkiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Spravki[ spravkiPK=" + spravkiPK + " ]";
    }
    
}
