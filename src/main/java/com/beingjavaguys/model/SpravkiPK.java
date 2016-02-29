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
public class SpravkiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "spisok_lpmo_kl")
    private int spisokLpmoKl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vidspravki")
    private int vidspravki;

    public SpravkiPK() {
    }

    public SpravkiPK(int spisokLpmoKl, int vidspravki) {
        this.spisokLpmoKl = spisokLpmoKl;
        this.vidspravki = vidspravki;
    }

    public int getSpisokLpmoKl() {
        return spisokLpmoKl;
    }

    public void setSpisokLpmoKl(int spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public int getVidspravki() {
        return vidspravki;
    }

    public void setVidspravki(int vidspravki) {
        this.vidspravki = vidspravki;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) spisokLpmoKl;
        hash += (int) vidspravki;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpravkiPK)) {
            return false;
        }
        SpravkiPK other = (SpravkiPK) object;
        if (this.spisokLpmoKl != other.spisokLpmoKl) {
            return false;
        }
        if (this.vidspravki != other.vidspravki) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SpravkiPK[ spisokLpmoKl=" + spisokLpmoKl + ", vidspravki=" + vidspravki + " ]";
    }
    
}
