/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "poseshenie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Poseshenie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_pos")
    @Temporal(TemporalType.DATE)
    private Date dataPos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utochn")
    private boolean utochn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zakl")
    private boolean zakl;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "poseshenie")
    private Dogovora dogovora;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenieId")
//    private Collection<DopVrLica> dopVrLicaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "poseshenie")
    private Potok potok;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenieId")
//    private Collection<ProfVrednosti> profVrednostiCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenieId")
//    private Collection<KontVesh> kontVeshCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenieId")
//    private Collection<MoI> moICollection;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "poseshenie")
    @JoinColumn(name = "oplata_id", referencedColumnName = "id")
    @ManyToOne
    private Oplata oplata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "poseshenie")
    private RezultatMo rezultatMo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenie")
//    private Collection<IstorijaTrodovoj> istorijaTrodovojCollection;
    @JoinColumn(name = "jurnal_rn", referencedColumnName = "rn")
    @ManyToOne(optional = false)
    private Jurnal jurnalRn;
    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl")
    @ManyToOne(optional = false)
    private SpisokLpmo spisokLpmoKl;
    @JoinColumn(name = "spr_prich_nejavki_na_mo_id", referencedColumnName = "id")
    @ManyToOne
    private SprPrichNejavkiNaMo sprPrichNejavkiNaMoId;
    @JoinColumn(name = "prichina_id", referencedColumnName = "id")
    @ManyToOne
    private SprPrichina prichinaId;
    @JoinColumn(name = "spr_vid_mo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprVidMo sprVidMoId;
    @JoinColumn(name = "rabota_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Rabota rabotaId;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poseshenie")
//    private Collection<Spravki> spravkiCollection;

    public Poseshenie() {
    }

//    public Poseshenie(Integer id) {
//        this.id = id;
//    }
//
//    public Poseshenie(Integer id, Date dataPos, boolean utochn, boolean zakl) {
//        this.id = id;
//        this.dataPos = dataPos;
//        this.utochn = utochn;
//        this.zakl = zakl;
//    }

    public Rabota getRabotaId() {
        return rabotaId;
    }

    public void setRabotaId(Rabota rabotaId) {
        this.rabotaId = rabotaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPos() {
        return dataPos;
    }

    public void setDataPos(Date dataPos) {
        this.dataPos = dataPos;
    }

    public boolean getUtochn() {
        return utochn;
    }

    public void setUtochn(boolean utochn) {
        this.utochn = utochn;
    }

    public boolean getZakl() {
        return zakl;
    }

    public void setZakl(boolean zakl) {
        this.zakl = zakl;
    }

    public Dogovora getDogovora() {
        return dogovora;
    }

    public void setDogovora(Dogovora dogovora) {
        this.dogovora = dogovora;
    }

//    public Collection<DopVrLica> getDopVrLicaCollection() {
//        return dopVrLicaCollection;
//    }
//
//    public void setDopVrLicaCollection(Collection<DopVrLica> dopVrLicaCollection) {
//        this.dopVrLicaCollection = dopVrLicaCollection;
//    }

    public Potok getPotok() {
        return potok;
    }

    public void setPotok(Potok potok) {
        this.potok = potok;
    }

//    public Collection<ProfVrednosti> getProfVrednostiCollection() {
//        return profVrednostiCollection;
//    }
//
//    public void setProfVrednostiCollection(Collection<ProfVrednosti> profVrednostiCollection) {
//        this.profVrednostiCollection = profVrednostiCollection;
//    }
//
//    public Collection<KontVesh> getKontVeshCollection() {
//        return kontVeshCollection;
//    }
//
//    public void setKontVeshCollection(Collection<KontVesh> kontVeshCollection) {
//        this.kontVeshCollection = kontVeshCollection;
//    }
//
//    public Collection<MoI> getMoICollection() {
//        return moICollection;
//    }
//
//    public void setMoICollection(Collection<MoI> moICollection) {
//        this.moICollection = moICollection;
//    }

    public Oplata getOplata() {
        return oplata;
    }

    public void setOplata(Oplata oplata) {
        this.oplata = oplata;
    }

    public RezultatMo getRezultatMo() {
        return rezultatMo;
    }

    public void setRezultatMo(RezultatMo rezultatMo) {
        this.rezultatMo = rezultatMo;
    }

//    public Collection<IstorijaTrodovoj> getIstorijaTrodovojCollection() {
//        return istorijaTrodovojCollection;
//    }
//
//    public void setIstorijaTrodovojCollection(Collection<IstorijaTrodovoj> istorijaTrodovojCollection) {
//        this.istorijaTrodovojCollection = istorijaTrodovojCollection;
//    }

    public Jurnal getJurnalRn() {
        return jurnalRn;
    }

    public void setJurnalRn(Jurnal jurnalRn) {
        this.jurnalRn = jurnalRn;
    }

    public SpisokLpmo getSpisokLpmoKl() {
        return spisokLpmoKl;
    }

    public void setSpisokLpmoKl(SpisokLpmo spisokLpmoKl) {
        this.spisokLpmoKl = spisokLpmoKl;
    }

    public SprPrichNejavkiNaMo getSprPrichNejavkiNaMoId() {
        return sprPrichNejavkiNaMoId;
    }

    public void setSprPrichNejavkiNaMoId(SprPrichNejavkiNaMo sprPrichNejavkiNaMoId) {
        this.sprPrichNejavkiNaMoId = sprPrichNejavkiNaMoId;
    }

    public SprPrichina getPrichinaId() {
        return prichinaId;
    }

    public void setPrichinaId(SprPrichina prichinaId) {
        this.prichinaId = prichinaId;
    }

    public SprVidMo getSprVidMoId() {
        return sprVidMoId;
    }

    public void setSprVidMoId(SprVidMo sprVidMoId) {
        this.sprVidMoId = sprVidMoId;
    }

//    public Collection<Spravki> getSpravkiCollection() {
//        return spravkiCollection;
//    }
//
//    public void setSpravkiCollection(Collection<Spravki> spravkiCollection) {
//        this.spravkiCollection = spravkiCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poseshenie)) {
            return false;
        }
        Poseshenie other = (Poseshenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Poseshenie[ id=" + id + " ]";
    }
    
}
