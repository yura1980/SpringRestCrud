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
@Table(name = "mkb_prioritet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MkbPrioritet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MkbPrioritetPK mkbPrioritetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prioritet")
    private int prioritet;

    public MkbPrioritet() {
    }

    public MkbPrioritet(MkbPrioritetPK mkbPrioritetPK) {
        this.mkbPrioritetPK = mkbPrioritetPK;
    }

    public MkbPrioritet(MkbPrioritetPK mkbPrioritetPK, int prioritet) {
        this.mkbPrioritetPK = mkbPrioritetPK;
        this.prioritet = prioritet;
    }

    public MkbPrioritet(int idMkb, int vrach) {
        this.mkbPrioritetPK = new MkbPrioritetPK(idMkb, vrach);
    }

    public MkbPrioritetPK getMkbPrioritetPK() {
        return mkbPrioritetPK;
    }

    public void setMkbPrioritetPK(MkbPrioritetPK mkbPrioritetPK) {
        this.mkbPrioritetPK = mkbPrioritetPK;
    }

    public int getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(int prioritet) {
        this.prioritet = prioritet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mkbPrioritetPK != null ? mkbPrioritetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbPrioritet)) {
            return false;
        }
        MkbPrioritet other = (MkbPrioritet) object;
        if ((this.mkbPrioritetPK == null && other.mkbPrioritetPK != null) || (this.mkbPrioritetPK != null && !this.mkbPrioritetPK.equals(other.mkbPrioritetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MkbPrioritet[ mkbPrioritetPK=" + mkbPrioritetPK + " ]";
    }
    
}
