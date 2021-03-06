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
@Table(name = "periodichnost_mo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PeriodichnostMo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spisok_lpmo_kl")
    private Integer spisokLpmoKl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period_mo_lpu")
    private int periodMoLpu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period_mo_cp")
    private int periodMoCp;
    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SpisokLpmo spisokLpmo;

    public PeriodichnostMo() {
    }

    public PeriodichnostMo(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public PeriodichnostMo(Integer spisokLpmoKl, int periodMoLpu, int periodMoCp) {
        this.spisokLpmoKl = spisokLpmoKl;
        this.periodMoLpu = periodMoLpu;
        this.periodMoCp = periodMoCp;
    }

    public Integer getSpisokLpmoKl() {
        return spisokLpmoKl;
    }

    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public int getPeriodMoLpu() {
        return periodMoLpu;
    }

    public void setPeriodMoLpu(int periodMoLpu) {
        this.periodMoLpu = periodMoLpu;
    }

    public int getPeriodMoCp() {
        return periodMoCp;
    }

    public void setPeriodMoCp(int periodMoCp) {
        this.periodMoCp = periodMoCp;
    }

    public SpisokLpmo getSpisokLpmo() {
        return spisokLpmo;
    }

    public void setSpisokLpmo(SpisokLpmo spisokLpmo) {
        this.spisokLpmo = spisokLpmo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spisokLpmoKl != null ? spisokLpmoKl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodichnostMo)) {
            return false;
        }
        PeriodichnostMo other = (PeriodichnostMo) object;
        if ((this.spisokLpmoKl == null && other.spisokLpmoKl != null) || (this.spisokLpmoKl != null && !this.spisokLpmoKl.equals(other.spisokLpmoKl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.PeriodichnostMo[ spisokLpmoKl=" + spisokLpmoKl + " ]";
    }
    
}
