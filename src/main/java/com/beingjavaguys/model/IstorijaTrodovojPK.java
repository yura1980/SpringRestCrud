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
public class IstorijaTrodovojPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "poseshenie_id")
    private int poseshenieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kl")
    private int kl;

    public IstorijaTrodovojPK() {
    }

    public IstorijaTrodovojPK(int poseshenieId, int kl) {
        this.poseshenieId = poseshenieId;
        this.kl = kl;
    }

    public int getPoseshenieId() {
        return poseshenieId;
    }

    public void setPoseshenieId(int poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

    public int getKl() {
        return kl;
    }

    public void setKl(int kl) {
        this.kl = kl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) poseshenieId;
        hash += (int) kl;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IstorijaTrodovojPK)) {
            return false;
        }
        IstorijaTrodovojPK other = (IstorijaTrodovojPK) object;
        if (this.poseshenieId != other.poseshenieId) {
            return false;
        }
        if (this.kl != other.kl) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.IstorijaTrodovojPK[ poseshenieId=" + poseshenieId + ", kl=" + kl + " ]";
    }
    
}
