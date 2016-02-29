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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_vid_otchetov_nast")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprVidOtchetovNast implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spr_vid_otchetov_id")
    private Integer sprVidOtchetovId;
    @Column(name = "lotok")
    private Integer lotok;
    @Column(name = "razmer")
    private Integer razmer;
    @Column(name = "kol_kop")
    private Integer kolKop;
    @Column(name = "kol_str")
    private Integer kolStr;
    @Size(max = 150)
    @Column(name = "s_sql")
    private String sSql;
    @JoinColumn(name = "spr_vid_otchetov_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SprVidOtchetov sprVidOtchetov;

    public SprVidOtchetovNast() {
    }

    public SprVidOtchetovNast(Integer sprVidOtchetovId) {
        this.sprVidOtchetovId = sprVidOtchetovId;
    }

    public Integer getSprVidOtchetovId() {
        return sprVidOtchetovId;
    }

    public void setSprVidOtchetovId(Integer sprVidOtchetovId) {
        this.sprVidOtchetovId = sprVidOtchetovId;
    }

    public Integer getLotok() {
        return lotok;
    }

    public void setLotok(Integer lotok) {
        this.lotok = lotok;
    }

    public Integer getRazmer() {
        return razmer;
    }

    public void setRazmer(Integer razmer) {
        this.razmer = razmer;
    }

    public Integer getKolKop() {
        return kolKop;
    }

    public void setKolKop(Integer kolKop) {
        this.kolKop = kolKop;
    }

    public Integer getKolStr() {
        return kolStr;
    }

    public void setKolStr(Integer kolStr) {
        this.kolStr = kolStr;
    }

    public String getSSql() {
        return sSql;
    }

    public void setSSql(String sSql) {
        this.sSql = sSql;
    }

    public SprVidOtchetov getSprVidOtchetov() {
        return sprVidOtchetov;
    }

    public void setSprVidOtchetov(SprVidOtchetov sprVidOtchetov) {
        this.sprVidOtchetov = sprVidOtchetov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sprVidOtchetovId != null ? sprVidOtchetovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprVidOtchetovNast)) {
            return false;
        }
        SprVidOtchetovNast other = (SprVidOtchetovNast) object;
        if ((this.sprVidOtchetovId == null && other.sprVidOtchetovId != null) || (this.sprVidOtchetovId != null && !this.sprVidOtchetovId.equals(other.sprVidOtchetovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprVidOtchetovNast[ sprVidOtchetovId=" + sprVidOtchetovId + " ]";
    }
    
}
