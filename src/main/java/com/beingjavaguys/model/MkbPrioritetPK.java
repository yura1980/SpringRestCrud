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
public class MkbPrioritetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mkb")
    private int idMkb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vrach")
    private int vrach;

    public MkbPrioritetPK() {
    }

    public MkbPrioritetPK(int idMkb, int vrach) {
        this.idMkb = idMkb;
        this.vrach = vrach;
    }

    public int getIdMkb() {
        return idMkb;
    }

    public void setIdMkb(int idMkb) {
        this.idMkb = idMkb;
    }

    public int getVrach() {
        return vrach;
    }

    public void setVrach(int vrach) {
        this.vrach = vrach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMkb;
        hash += (int) vrach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbPrioritetPK)) {
            return false;
        }
        MkbPrioritetPK other = (MkbPrioritetPK) object;
        if (this.idMkb != other.idMkb) {
            return false;
        }
        if (this.vrach != other.vrach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MkbPrioritetPK[ idMkb=" + idMkb + ", vrach=" + vrach + " ]";
    }
    
}
