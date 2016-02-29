/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_vid_otchetov")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprVidOtchetov  extends Spr {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sokr")
    private String sokr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "otchet")
    private String otchet;
    @Size(max = 70)
    @Column(name = "opisanie")
    private String opisanie;
    @Column(name = "tip")
    private Integer tip;
    @Size(max = 75)
    @Column(name = "nazv_otcheta")
    private String nazvOtcheta;
    @Size(max = 45)
    @Column(name = "nazv_zaprosa")
    private String nazvZaprosa;
    @Column(name = "vid_otcheta")
    private Integer vidOtcheta;
    @Column(name = "razmer")
    private Integer razmer;
    @Column(name = "kol_kop")
    private Integer kolKop;
    @Column(name = "kol_str")
    private Integer kolStr;
    @Column(name = "prior")
    private Integer prior;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sprVidOtchetov")
    private SprVidOtchetovNast sprVidOtchetovNast;

    public SprVidOtchetov() {
    }

    /*public SprVidOtchetov(Integer id) {
        this.id = id;
    }

    public SprVidOtchetov(Integer id, String sokr, String otchet) {
        this.id = id;
        this.sokr = sokr;
        this.otchet = otchet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getSokr() {
        return sokr;
    }

    public void setSokr(String sokr) {
        this.sokr = sokr;
    }

    public String getOtchet() {
        return otchet;
    }

    public void setOtchet(String otchet) {
        this.otchet = otchet;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public String getNazvOtcheta() {
        return nazvOtcheta;
    }

    public void setNazvOtcheta(String nazvOtcheta) {
        this.nazvOtcheta = nazvOtcheta;
    }

    public String getNazvZaprosa() {
        return nazvZaprosa;
    }

    public void setNazvZaprosa(String nazvZaprosa) {
        this.nazvZaprosa = nazvZaprosa;
    }

    public Integer getVidOtcheta() {
        return vidOtcheta;
    }

    public void setVidOtcheta(Integer vidOtcheta) {
        this.vidOtcheta = vidOtcheta;
    }

    public Integer getRazmer() {
        return razmer;
    }

    public void setRazmer(Integer razmer) {
        this.razmer = razmer;
    }

    public Integer getKolKop() {
        return kolKop;
    }

    public void setKolKop(Integer kolKop) {
        this.kolKop = kolKop;
    }

    public Integer getKolStr() {
        return kolStr;
    }

    public void setKolStr(Integer kolStr) {
        this.kolStr = kolStr;
    }

    public Integer getPrior() {
        return prior;
    }

    public void setPrior(Integer prior) {
        this.prior = prior;
    }

    public SprVidOtchetovNast getSprVidOtchetovNast() {
        return sprVidOtchetovNast;
    }

    public void setSprVidOtchetovNast(SprVidOtchetovNast sprVidOtchetovNast) {
        this.sprVidOtchetovNast = sprVidOtchetovNast;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprVidOtchetov)) {
            return false;
        }
        SprVidOtchetov other = (SprVidOtchetov) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprVidOtchetov[ id=" + id + " ]";
    }*/
    
}
