/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "invalidnost")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invalidnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spisok_lpmo_kl")
    private Integer spisokLpmoKl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invalidnost")
    private int invalidnost;
    @Column(name = "datas_poluch_inval")
    @Temporal(TemporalType.DATE)
    private Date datasPoluchInval;
    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SpisokLpmo spisokLpmo;

    public Invalidnost() {
    }

    public Invalidnost(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public Invalidnost(Integer spisokLpmoKl, int invalidnost) {
        this.spisokLpmoKl = spisokLpmoKl;
        this.invalidnost = invalidnost;
    }

    public Integer getSpisokLpmoKl() {
        return spisokLpmoKl;
    }

    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public int getInvalidnost() {
        return invalidnost;
    }

    public void setInvalidnost(int invalidnost) {
        this.invalidnost = invalidnost;
    }

    public Date getDatasPoluchInval() {
        return datasPoluchInval;
    }

    public void setDatasPoluchInval(Date datasPoluchInval) {
        this.datasPoluchInval = datasPoluchInval;
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
        if (!(object instanceof Invalidnost)) {
            return false;
        }
        Invalidnost other = (Invalidnost) object;
        if ((this.spisokLpmoKl == null && other.spisokLpmoKl != null) || (this.spisokLpmoKl != null && !this.spisokLpmoKl.equals(other.spisokLpmoKl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Invalidnost[ spisokLpmoKl=" + spisokLpmoKl + " ]";
    }
    
}
