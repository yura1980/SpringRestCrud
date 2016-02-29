/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "events_mo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventsMo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_par")
    private Integer idPar;
    @Size(max = 70)
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "data_time")
    @Temporal(TemporalType.DATE)
    private Date dataTime;
    @Column(name = "vrach_issled")
    private Integer vrachIssled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bvi")
    private boolean bvi;
    @Column(name = "kl")
    private Integer kl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ppokaz")
    private boolean ppokaz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oplata_obs")
    private boolean oplataObs;
    @Size(max = 300)
    @Column(name = "dop_inf_obsh")
    private String dopInfObsh;
    @Size(max = 300)
    @Column(name = "dop_inf_spec")
    private String dopInfSpec;
    @Column(name = "prod_trud_dejat")
    private Integer prodTrudDejat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provedeno")
    private boolean provedeno;

    public EventsMo() {
    }

    public EventsMo(Integer id) {
        this.id = id;
    }

    public EventsMo(Integer id, boolean bvi, boolean ppokaz, boolean oplataObs, boolean provedeno) {
        this.id = id;
        this.bvi = bvi;
        this.ppokaz = ppokaz;
        this.oplataObs = oplataObs;
        this.provedeno = provedeno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPar() {
        return idPar;
    }

    public void setIdPar(Integer idPar) {
        this.idPar = idPar;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getVrachIssled() {
        return vrachIssled;
    }

    public void setVrachIssled(Integer vrachIssled) {
        this.vrachIssled = vrachIssled;
    }

    public boolean getBvi() {
        return bvi;
    }

    public void setBvi(boolean bvi) {
        this.bvi = bvi;
    }

    public Integer getKl() {
        return kl;
    }

    public void setKl(Integer kl) {
        this.kl = kl;
    }

    public boolean getPpokaz() {
        return ppokaz;
    }

    public void setPpokaz(boolean ppokaz) {
        this.ppokaz = ppokaz;
    }

    public boolean getOplataObs() {
        return oplataObs;
    }

    public void setOplataObs(boolean oplataObs) {
        this.oplataObs = oplataObs;
    }

    public String getDopInfObsh() {
        return dopInfObsh;
    }

    public void setDopInfObsh(String dopInfObsh) {
        this.dopInfObsh = dopInfObsh;
    }

    public String getDopInfSpec() {
        return dopInfSpec;
    }

    public void setDopInfSpec(String dopInfSpec) {
        this.dopInfSpec = dopInfSpec;
    }

    public Integer getProdTrudDejat() {
        return prodTrudDejat;
    }

    public void setProdTrudDejat(Integer prodTrudDejat) {
        this.prodTrudDejat = prodTrudDejat;
    }

    public boolean getProvedeno() {
        return provedeno;
    }

    public void setProvedeno(boolean provedeno) {
        this.provedeno = provedeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventsMo)) {
            return false;
        }
        EventsMo other = (EventsMo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package com.beingjavaguys.model;.EventsMo[ id=" + id + " ]";
    }
    
}
