/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "adres")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip")
    private boolean tip;

    @Size(max = 10)
    @Column(name = "nomer_doma")
    private String nomerDoma;
    @Size(max = 10)
    @Column(name = "korpus")
    private String korpus;
    @Size(max = 10)
    @Column(name = "nomer_kvartiry")
    private String nomerKvartiry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "adres")
    private String adres;
//    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private SpisokLpmo spisokLpmo;
    @JoinColumn(name = "spr_gorod_id", referencedColumnName = "id")
    @ManyToOne
    private SprGorod sprGorodId;
    @JoinColumn(name = "spr_nasel_punkt_id", referencedColumnName = "id")
    @ManyToOne
    private SprNaselPunkt sprNaselPunktId;
    @JoinColumn(name = "spr_oblast_id", referencedColumnName = "id")
    @ManyToOne
    private SprOblast sprOblastId;
    @JoinColumn(name = "spr_raion_id", referencedColumnName = "id")
    @ManyToOne
    private SprRaion sprRaionId;
    @JoinColumn(name = "spr_ulici_id", referencedColumnName = "id")
    @ManyToOne
    private SprUlici sprUliciId;

    public Adres() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTip() {
        return tip;
    }

    public void setTip(boolean tip) {
        this.tip = tip;
    }

    //    public Adres(AdresPK adresPK) {
//        this.adresPK = adresPK;
//    }
//
//    public Adres(AdresPK adresPK, String adres) {
//        this.adresPK = adresPK;
//        this.adres = adres;
//    }
//
//    public Adres(int spisokLpmoKl, boolean tip) {
//        this.adresPK = new AdresPK(spisokLpmoKl, tip);
//    }
//
//    public AdresPK getAdresPK() {
//        return adresPK;
//    }
//
//    public void setAdresPK(AdresPK adresPK) {
//        this.adresPK = adresPK;
//    }

    public String getNomerDoma() {
        return nomerDoma;
    }

    public void setNomerDoma(String nomerDoma) {
        this.nomerDoma = nomerDoma;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public String getNomerKvartiry() {
        return nomerKvartiry;
    }

    public void setNomerKvartiry(String nomerKvartiry) {
        this.nomerKvartiry = nomerKvartiry;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

//    public SpisokLpmo getSpisokLpmo() {
//        return spisokLpmo;
//    }
//
//    public void setSpisokLpmo(SpisokLpmo spisokLpmo) {
//        this.spisokLpmo = spisokLpmo;
//    }

    public SprGorod getSprGorodId() {
        return sprGorodId;
    }

    public void setSprGorodId(SprGorod sprGorodId) {
        this.sprGorodId = sprGorodId;
    }

    public SprNaselPunkt getSprNaselPunktId() {
        return sprNaselPunktId;
    }

    public void setSprNaselPunktId(SprNaselPunkt sprNaselPunktId) {
        this.sprNaselPunktId = sprNaselPunktId;
    }

    public SprOblast getSprOblastId() {
        return sprOblastId;
    }

    public void setSprOblastId(SprOblast sprOblastId) {
        this.sprOblastId = sprOblastId;
    }

    public SprRaion getSprRaionId() {
        return sprRaionId;
    }

    public void setSprRaionId(SprRaion sprRaionId) {
        this.sprRaionId = sprRaionId;
    }

    public SprUlici getSprUliciId() {
        return sprUliciId;
    }

    public void setSprUliciId(SprUlici sprUliciId) {
        this.sprUliciId = sprUliciId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adres[ id=" + id + " ]";
    }
    
}
