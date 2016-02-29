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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "rezultat_mo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RezultatMo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "poseshenie_id")
    private Integer poseshenieId;
    @Size(max = 700)
    @Column(name = "zakljuchenie")
    private String zakljuchenie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zdorov")
    private boolean zdorov;
    @Column(name = "gr")
    private Integer gr;
    @Column(name = "data_zak")
    @Temporal(TemporalType.DATE)
    private Date dataZak;
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viyav_vperv")
    private boolean viyavVperv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezultatMoPoseshenieId")
    private Collection<RezMoVlozh> rezMoVlozhCollection;
    @JoinColumn(name = "poseshenie_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Poseshenie poseshenie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezultatMoPoseshenieId")
    private Collection<RezLom> rezLomCollection;

    public RezultatMo() {
    }

    public RezultatMo(Integer poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

    public RezultatMo(Integer poseshenieId, boolean zdorov, boolean viyavVperv) {
        this.poseshenieId = poseshenieId;
        this.zdorov = zdorov;
        this.viyavVperv = viyavVperv;
    }

    public Integer getPoseshenieId() {
        return poseshenieId;
    }

    public void setPoseshenieId(Integer poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

    public String getZakljuchenie() {
        return zakljuchenie;
    }

    public void setZakljuchenie(String zakljuchenie) {
        this.zakljuchenie = zakljuchenie;
    }

    public boolean getZdorov() {
        return zdorov;
    }

    public void setZdorov(boolean zdorov) {
        this.zdorov = zdorov;
    }

    public Integer getGr() {
        return gr;
    }

    public void setGr(Integer gr) {
        this.gr = gr;
    }

    public Date getDataZak() {
        return dataZak;
    }

    public void setDataZak(Date dataZak) {
        this.dataZak = dataZak;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public boolean getViyavVperv() {
        return viyavVperv;
    }

    public void setViyavVperv(boolean viyavVperv) {
        this.viyavVperv = viyavVperv;
    }

    public Collection<RezMoVlozh> getRezMoVlozhCollection() {
        return rezMoVlozhCollection;
    }

    public void setRezMoVlozhCollection(Collection<RezMoVlozh> rezMoVlozhCollection) {
        this.rezMoVlozhCollection = rezMoVlozhCollection;
    }

    public Poseshenie getPoseshenie() {
        return poseshenie;
    }

    public void setPoseshenie(Poseshenie poseshenie) {
        this.poseshenie = poseshenie;
    }

    public Collection<RezLom> getRezLomCollection() {
        return rezLomCollection;
    }

    public void setRezLomCollection(Collection<RezLom> rezLomCollection) {
        this.rezLomCollection = rezLomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poseshenieId != null ? poseshenieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RezultatMo)) {
            return false;
        }
        RezultatMo other = (RezultatMo) object;
        if ((this.poseshenieId == null && other.poseshenieId != null) || (this.poseshenieId != null && !this.poseshenieId.equals(other.poseshenieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.RezultatMo[ poseshenieId=" + poseshenieId + " ]";
    }
    
}
