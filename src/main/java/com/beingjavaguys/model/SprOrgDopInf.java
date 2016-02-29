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
import javax.persistence.ManyToOne;
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
@Table(name = "spr_org_dop_inf")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprOrgDopInf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "spr_org_id")
    private Integer sprOrgId;
    @Column(name = "dolg_ruk")
    private Integer dolgRuk;
    @Size(max = 75)
    @Column(name = "fio_ruk")
    private String fioRuk;
    @Column(name = "pred_trud_kol")
    private Integer predTrudKol;
    @Size(max = 75)
    @Column(name = "fio_pred_trud_kol")
    private String fioPredTrudKol;
    @Size(max = 150)
    @Column(name = "jur_adres")
    private String jurAdres;
    @Size(max = 150)
    @Column(name = "fakt_adres")
    private String faktAdres;
    @Column(name = "kol_vsego")
    private Integer kolVsego;
    @Column(name = "kol_zhen")
    private Integer kolZhen;
    @Column(name = "kol_18")
    private Integer kol18;
    @Column(name = "kol_utr")
    private Integer kolUtr;
    @Column(name = "kol_vr_usl")
    private Integer kolVrUsl;
    @Column(name = "kol_vr_usl_zh")
    private Integer kolVrUslZh;
    @Column(name = "datas_vydachi")
    @Temporal(TemporalType.DATE)
    private Date datasVydachi;
    @Size(max = 75)
    @Column(name = "sokr_org")
    private String sokrOrg;
    @JoinColumn(name = "spr_form_sobs_org_id", referencedColumnName = "id")
    @ManyToOne
    private SprFormSobsOrg sprFormSobsOrgId;
    @JoinColumn(name = "spr_org_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SprOrg sprOrg;
    @JoinColumn(name = "spr_tip_org_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprTipOrg sprTipOrgId;
    @JoinColumn(name = "spr_vid_ek_dejt_org_id", referencedColumnName = "id")
    @ManyToOne
    private SprVidEkDejtOrg sprVidEkDejtOrgId;

    public SprOrgDopInf() {
    }

    public SprOrgDopInf(Integer sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public Integer getSprOrgId() {
        return sprOrgId;
    }

    public void setSprOrgId(Integer sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public Integer getDolgRuk() {
        return dolgRuk;
    }

    public void setDolgRuk(Integer dolgRuk) {
        this.dolgRuk = dolgRuk;
    }

    public String getFioRuk() {
        return fioRuk;
    }

    public void setFioRuk(String fioRuk) {
        this.fioRuk = fioRuk;
    }

    public Integer getPredTrudKol() {
        return predTrudKol;
    }

    public void setPredTrudKol(Integer predTrudKol) {
        this.predTrudKol = predTrudKol;
    }

    public String getFioPredTrudKol() {
        return fioPredTrudKol;
    }

    public void setFioPredTrudKol(String fioPredTrudKol) {
        this.fioPredTrudKol = fioPredTrudKol;
    }

    public String getJurAdres() {
        return jurAdres;
    }

    public void setJurAdres(String jurAdres) {
        this.jurAdres = jurAdres;
    }

    public String getFaktAdres() {
        return faktAdres;
    }

    public void setFaktAdres(String faktAdres) {
        this.faktAdres = faktAdres;
    }

    public Integer getKolVsego() {
        return kolVsego;
    }

    public void setKolVsego(Integer kolVsego) {
        this.kolVsego = kolVsego;
    }

    public Integer getKolZhen() {
        return kolZhen;
    }

    public void setKolZhen(Integer kolZhen) {
        this.kolZhen = kolZhen;
    }

    public Integer getKol18() {
        return kol18;
    }

    public void setKol18(Integer kol18) {
        this.kol18 = kol18;
    }

    public Integer getKolUtr() {
        return kolUtr;
    }

    public void setKolUtr(Integer kolUtr) {
        this.kolUtr = kolUtr;
    }

    public Integer getKolVrUsl() {
        return kolVrUsl;
    }

    public void setKolVrUsl(Integer kolVrUsl) {
        this.kolVrUsl = kolVrUsl;
    }

    public Integer getKolVrUslZh() {
        return kolVrUslZh;
    }

    public void setKolVrUslZh(Integer kolVrUslZh) {
        this.kolVrUslZh = kolVrUslZh;
    }

    public Date getDatasVydachi() {
        return datasVydachi;
    }

    public void setDatasVydachi(Date datasVydachi) {
        this.datasVydachi = datasVydachi;
    }

    public String getSokrOrg() {
        return sokrOrg;
    }

    public void setSokrOrg(String sokrOrg) {
        this.sokrOrg = sokrOrg;
    }

    public SprFormSobsOrg getSprFormSobsOrgId() {
        return sprFormSobsOrgId;
    }

    public void setSprFormSobsOrgId(SprFormSobsOrg sprFormSobsOrgId) {
        this.sprFormSobsOrgId = sprFormSobsOrgId;
    }

    public SprOrg getSprOrg() {
        return sprOrg;
    }

    public void setSprOrg(SprOrg sprOrg) {
        this.sprOrg = sprOrg;
    }

    public SprTipOrg getSprTipOrgId() {
        return sprTipOrgId;
    }

    public void setSprTipOrgId(SprTipOrg sprTipOrgId) {
        this.sprTipOrgId = sprTipOrgId;
    }

    public SprVidEkDejtOrg getSprVidEkDejtOrgId() {
        return sprVidEkDejtOrgId;
    }

    public void setSprVidEkDejtOrgId(SprVidEkDejtOrg sprVidEkDejtOrgId) {
        this.sprVidEkDejtOrgId = sprVidEkDejtOrgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sprOrgId != null ? sprOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprOrgDopInf)) {
            return false;
        }
        SprOrgDopInf other = (SprOrgDopInf) object;
        if ((this.sprOrgId == null && other.sprOrgId != null) || (this.sprOrgId != null && !this.sprOrgId.equals(other.sprOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprOrgDopInf[ sprOrgId=" + sprOrgId + " ]";
    }
    
}
