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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "migrant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Migrant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pasporta_spisok_lpmo_kl")
    private Integer pasportaSpisokLpmoKl;
    @Column(name = "per_d1")
    @Temporal(TemporalType.DATE)
    private Date perD1;
    @Column(name = "per_d2")
    @Temporal(TemporalType.DATE)
    private Date perD2;
    @Column(name = "flg_d")
    @Temporal(TemporalType.DATE)
    private Date flgD;
    @Column(name = "flg_polikl")
    private Integer flgPolikl;
    @Size(max = 45)
    @Column(name = "flg_rez")
    private String flgRez;
    @Column(name = "cif_d")
    @Temporal(TemporalType.DATE)
    private Date cifD;
    @Size(max = 7)
    @Column(name = "cif_n")
    private String cifN;
    @Size(max = 45)
    @Column(name = "cif_rez")
    private String cifRez;
    @Size(max = 45)
    @Column(name = "cif_fio")
    private String cifFio;
    @Column(name = "sh_d")
    @Temporal(TemporalType.DATE)
    private Date shD;
    @Size(max = 7)
    @Column(name = "sh_n")
    private String shN;
    @Size(max = 45)
    @Column(name = "sh_rez")
    private String shRez;
    @Size(max = 45)
    @Column(name = "sh_fio")
    private String shFio;
//    @JoinColumn(name = "pasporta_spisok_lpmo_kl", referencedColumnName = "spisok_lpmo_kl", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Pasporta pasporta;

    public Migrant() {
    }

    public Migrant(Integer pasportaSpisokLpmoKl) {
        this.pasportaSpisokLpmoKl = pasportaSpisokLpmoKl;
    }

    public Integer getPasportaSpisokLpmoKl() {
        return pasportaSpisokLpmoKl;
    }

    public void setPasportaSpisokLpmoKl(Integer pasportaSpisokLpmoKl) {
        this.pasportaSpisokLpmoKl = pasportaSpisokLpmoKl;
    }

    public Date getPerD1() {
        return perD1;
    }

    public void setPerD1(Date perD1) {
        this.perD1 = perD1;
    }

    public Date getPerD2() {
        return perD2;
    }

    public void setPerD2(Date perD2) {
        this.perD2 = perD2;
    }

    public Date getFlgD() {
        return flgD;
    }

    public void setFlgD(Date flgD) {
        this.flgD = flgD;
    }

    public Integer getFlgPolikl() {
        return flgPolikl;
    }

    public void setFlgPolikl(Integer flgPolikl) {
        this.flgPolikl = flgPolikl;
    }

    public String getFlgRez() {
        return flgRez;
    }

    public void setFlgRez(String flgRez) {
        this.flgRez = flgRez;
    }

    public Date getCifD() {
        return cifD;
    }

    public void setCifD(Date cifD) {
        this.cifD = cifD;
    }

    public String getCifN() {
        return cifN;
    }

    public void setCifN(String cifN) {
        this.cifN = cifN;
    }

    public String getCifRez() {
        return cifRez;
    }

    public void setCifRez(String cifRez) {
        this.cifRez = cifRez;
    }

    public String getCifFio() {
        return cifFio;
    }

    public void setCifFio(String cifFio) {
        this.cifFio = cifFio;
    }

    public Date getShD() {
        return shD;
    }

    public void setShD(Date shD) {
        this.shD = shD;
    }

    public String getShN() {
        return shN;
    }

    public void setShN(String shN) {
        this.shN = shN;
    }

    public String getShRez() {
        return shRez;
    }

    public void setShRez(String shRez) {
        this.shRez = shRez;
    }

    public String getShFio() {
        return shFio;
    }

    public void setShFio(String shFio) {
        this.shFio = shFio;
    }

//    public Pasporta getPasporta() {
//        return pasporta;
//    }
//
//    public void setPasporta(Pasporta pasporta) {
//        this.pasporta = pasporta;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasportaSpisokLpmoKl != null ? pasportaSpisokLpmoKl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Migrant)) {
            return false;
        }
        Migrant other = (Migrant) object;
        if ((this.pasportaSpisokLpmoKl == null && other.pasportaSpisokLpmoKl != null) || (this.pasportaSpisokLpmoKl != null && !this.pasportaSpisokLpmoKl.equals(other.pasportaSpisokLpmoKl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Migrant[ pasportaSpisokLpmoKl=" + pasportaSpisokLpmoKl + " ]";
    }
    
}
