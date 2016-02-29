/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Embeddable
public class PricePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_org")
    private int idOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vr")
    private int idVr;

    public PricePK() {
    }

    public PricePK(int idOrg, int idVr) {
        this.idOrg = idOrg;
        this.idVr = idVr;
    }

    public int getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    public int getIdVr() {
        return idVr;
    }

    public void setIdVr(int idVr) {
        this.idVr = idVr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrg;
        hash += (int) idVr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricePK)) {
            return false;
        }
        PricePK other = (PricePK) object;
        if (this.idOrg != other.idOrg) {
            return false;
        }
        if (this.idVr != other.idVr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.PricePK[ idOrg=" + idOrg + ", idVr=" + idVr + " ]";
    }
    
}
