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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "price")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PricePK pricePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vr")
    private boolean vr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vkl")
    private boolean vkl;

    public Price() {
    }

    public Price(PricePK pricePK) {
        this.pricePK = pricePK;
    }

    public Price(PricePK pricePK, boolean vr, boolean vkl) {
        this.pricePK = pricePK;
        this.vr = vr;
        this.vkl = vkl;
    }

    public Price(int idOrg, int idVr) {
        this.pricePK = new PricePK(idOrg, idVr);
    }

    public PricePK getPricePK() {
        return pricePK;
    }

    public void setPricePK(PricePK pricePK) {
        this.pricePK = pricePK;
    }

    public boolean getVr() {
        return vr;
    }

    public void setVr(boolean vr) {
        this.vr = vr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getVkl() {
        return vkl;
    }

    public void setVkl(boolean vkl) {
        this.vkl = vkl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricePK != null ? pricePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.pricePK == null && other.pricePK != null) || (this.pricePK != null && !this.pricePK.equals(other.pricePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Price[ pricePK=" + pricePK + " ]";
    }
    
}
