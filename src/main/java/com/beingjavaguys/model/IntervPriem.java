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
@Table(name = "interv_priem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IntervPriem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spr_vrach_issl_id")
    private Integer sprVrachIsslId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intv")
    private int intv;
    @JoinColumn(name = "spr_vrach_issl_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SprVrachIssl sprVrachIssl;

    public IntervPriem() {
    }

    public IntervPriem(Integer sprVrachIsslId) {
        this.sprVrachIsslId = sprVrachIsslId;
    }

    public IntervPriem(Integer sprVrachIsslId, int intv) {
        this.sprVrachIsslId = sprVrachIsslId;
        this.intv = intv;
    }

    public Integer getSprVrachIsslId() {
        return sprVrachIsslId;
    }

    public void setSprVrachIsslId(Integer sprVrachIsslId) {
        this.sprVrachIsslId = sprVrachIsslId;
    }

    public int getIntv() {
        return intv;
    }

    public void setIntv(int intv) {
        this.intv = intv;
    }

    public SprVrachIssl getSprVrachIssl() {
        return sprVrachIssl;
    }

    public void setSprVrachIssl(SprVrachIssl sprVrachIssl) {
        this.sprVrachIssl = sprVrachIssl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sprVrachIsslId != null ? sprVrachIsslId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntervPriem)) {
            return false;
        }
        IntervPriem other = (IntervPriem) object;
        if ((this.sprVrachIsslId == null && other.sprVrachIsslId != null) || (this.sprVrachIsslId != null && !this.sprVrachIsslId.equals(other.sprVrachIsslId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.IntervPriem[ sprVrachIsslId=" + sprVrachIsslId + " ]";
    }
    
}
