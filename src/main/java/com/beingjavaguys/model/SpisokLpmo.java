/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "spisok_lpmo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SpisokLpmo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kl")
    private Integer kl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pol")
    private boolean pol;
    @Column(name = "datas_rozhd")
    @Temporal(TemporalType.DATE)
    private Date datasRozhd;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private Collection<Adres> adresCollection;
//    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "spisokLpmo")
//    private Rabota rabota;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private Obshhee obshhee;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private MedKarty medKarty;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private Pasporta pasporta;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spisokLpmoKl")
//    private Collection<Poseshenie> poseshenieCollection;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private PeriodichnostMo periodichnostMo;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spisokLpmo")
//    private Invalidnost invalidnost;
    @JoinColumn(name = "spr_fam_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprFam sprFamId;
    @JoinColumn(name = "spr_name_id", referencedColumnName = "id")
    @ManyToOne
    private SprName sprNameId;
    @JoinColumn(name = "spr_otch_id", referencedColumnName = "id")
    @ManyToOne
    private SprOtch sprOtchId;
    @JoinColumn(name = "pasporta_id", referencedColumnName = "id")
    @OneToOne
    private Pasporta pasportaId;

    public SpisokLpmo() {
    }

    public SpisokLpmo(Integer kl) {
        this.kl = kl;
    }

    public SpisokLpmo(Integer kl, boolean pol) {
        this.kl = kl;
        this.pol = pol;
    }

    public Integer getKl() {
        return kl;
    }

    public void setKl(Integer kl) {
        this.kl = kl;
    }

    public boolean getPol() {
        return pol;
    }

    public void setPol(boolean pol) {
        this.pol = pol;
    }

    public Date getDatasRozhd() {
        return datasRozhd;
    }

    public void setDatasRozhd(Date datasRozhd) {
        this.datasRozhd = datasRozhd;
    }

//    public Collection<Adres> getAdresCollection() {
//        return adresCollection;
//    }
//
//    public void setAdresCollection(Collection<Adres> adresCollection) {
//        this.adresCollection = adresCollection;
//    }

//    public Rabota getRabota() {
//        return rabota;
//    }
//
//    public void setRabota(Rabota rabota) {
//        this.rabota = rabota;
//    }
//
//    public Obshhee getObshhee() {
//        return obshhee;
//    }
//
//    public void setObshhee(Obshhee obshhee) {
//        this.obshhee = obshhee;
//    }
//
//    public MedKarty getMedKarty() {
//        return medKarty;
//    }
//
//    public void setMedKarty(MedKarty medKarty) {
//        this.medKarty = medKarty;
//    }
//
//    public Pasporta getPasporta() {
//        return pasporta;
//    }
//
//    public void setPasporta(Pasporta pasporta) {
//        this.pasporta = pasporta;
//    }

//    public Collection<Poseshenie> getPoseshenieCollection() {
//        return poseshenieCollection;
//    }
//
//    public void setPoseshenieCollection(Collection<Poseshenie> poseshenieCollection) {
//        this.poseshenieCollection = poseshenieCollection;
//    }

//    public PeriodichnostMo getPeriodichnostMo() {
//        return periodichnostMo;
//    }
//
//    public void setPeriodichnostMo(PeriodichnostMo periodichnostMo) {
//        this.periodichnostMo = periodichnostMo;
//    }
//
//    public Invalidnost getInvalidnost() {
//        return invalidnost;
//    }
//
//    public void setInvalidnost(Invalidnost invalidnost) {
//        this.invalidnost = invalidnost;
//    }

    public Pasporta getPasportaId() {
        return pasportaId;
    }

    public void setPasportaId(Pasporta pasportaId) {
        this.pasportaId = pasportaId;
    }

    public SprFam getSprFamId() {
        return sprFamId;
    }

    public void setSprFamId(SprFam sprFamId) {
        this.sprFamId = sprFamId;
    }

    public SprName getSprNameId() {
        return sprNameId;
    }

    public void setSprNameId(SprName sprNameId) {
        this.sprNameId = sprNameId;
    }

    public SprOtch getSprOtchId() {
        return sprOtchId;
    }

    public void setSprOtchId(SprOtch sprOtchId) {
        this.sprOtchId = sprOtchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kl != null ? kl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpisokLpmo)) {
            return false;
        }
        SpisokLpmo other = (SpisokLpmo) object;
        if ((this.kl == null && other.kl != null) || (this.kl != null && !this.kl.equals(other.kl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpisokLpmo[ kl=" + kl + " ]";
    }
    
}
