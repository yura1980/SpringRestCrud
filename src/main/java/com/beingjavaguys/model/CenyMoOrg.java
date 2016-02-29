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
@Table(name = "ceny_mo_org")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CenyMoOrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spr_org_id")
    private Integer sprOrgId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena_m")
    private Double cenaM;
    @Column(name = "cena_zh")
    private Double cenaZh;
    @Column(name = "cena_zh40")
    private Double cenaZh40;
    @Column(name = "skidka")
    private Double skidka;
    @JoinColumn(name = "spr_org_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SprOrg sprOrg;

    public CenyMoOrg() {
    }

    public CenyMoOrg(Integer sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public Integer getSprOrgId() {
        return sprOrgId;
    }

    public void setSprOrgId(Integer sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public Double getCenaM() {
        return cenaM;
    }

    public void setCenaM(Double cenaM) {
        this.cenaM = cenaM;
    }

    public Double getCenaZh() {
        return cenaZh;
    }

    public void setCenaZh(Double cenaZh) {
        this.cenaZh = cenaZh;
    }

    public Double getCenaZh40() {
        return cenaZh40;
    }

    public void setCenaZh40(Double cenaZh40) {
        this.cenaZh40 = cenaZh40;
    }

    public Double getSkidka() {
        return skidka;
    }

    public void setSkidka(Double skidka) {
        this.skidka = skidka;
    }

    public SprOrg getSprOrg() {
        return sprOrg;
    }

    public void setSprOrg(SprOrg sprOrg) {
        this.sprOrg = sprOrg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sprOrgId != null ? sprOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CenyMoOrg)) {
            return false;
        }
        CenyMoOrg other = (CenyMoOrg) object;
        if ((this.sprOrgId == null && other.sprOrgId != null) || (this.sprOrgId != null && !this.sprOrgId.equals(other.sprOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.CenyMoOrg[ sprOrgId=" + sprOrgId + " ]";
    }
    
}
