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
@Table(name = "dop_info_mo_i")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DopInfoMoI implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mo_i_id")
    private Integer moIId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oplata_obsl")
    private boolean oplataObsl;
    @Size(max = 700)
    @Column(name = "dop_inf_obshhaja")
    private String dopInfObshhaja;
    @Size(max = 300)
    @Column(name = "dop_inf_spec")
    private String dopInfSpec;
    @Column(name = "prod_trud_dejatelnost")
    private Integer prodTrudDejatelnost;
    @Column(name = "datas")
    @Temporal(TemporalType.DATE)
    private Date datas;
    @Column(name = "kol")
    private Integer kol;
    @Column(name = "id_user")
    private Integer idUser;
    @JoinColumn(name = "mo_i_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MoI moI;

    public DopInfoMoI() {
    }

    public DopInfoMoI(Integer moIId) {
        this.moIId = moIId;
    }

    public DopInfoMoI(Integer moIId, boolean oplataObsl) {
        this.moIId = moIId;
        this.oplataObsl = oplataObsl;
    }

    public Integer getMoIId() {
        return moIId;
    }

    public void setMoIId(Integer moIId) {
        this.moIId = moIId;
    }

    public boolean getOplataObsl() {
        return oplataObsl;
    }

    public void setOplataObsl(boolean oplataObsl) {
        this.oplataObsl = oplataObsl;
    }

    public String getDopInfObshhaja() {
        return dopInfObshhaja;
    }

    public void setDopInfObshhaja(String dopInfObshhaja) {
        this.dopInfObshhaja = dopInfObshhaja;
    }

    public String getDopInfSpec() {
        return dopInfSpec;
    }

    public void setDopInfSpec(String dopInfSpec) {
        this.dopInfSpec = dopInfSpec;
    }

    public Integer getProdTrudDejatelnost() {
        return prodTrudDejatelnost;
    }

    public void setProdTrudDejatelnost(Integer prodTrudDejatelnost) {
        this.prodTrudDejatelnost = prodTrudDejatelnost;
    }

    public Date getDatas() {
        return datas;
    }

    public void setDatas(Date datas) {
        this.datas = datas;
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public MoI getMoI() {
        return moI;
    }

    public void setMoI(MoI moI) {
        this.moI = moI;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moIId != null ? moIId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DopInfoMoI)) {
            return false;
        }
        DopInfoMoI other = (DopInfoMoI) object;
        if ((this.moIId == null && other.moIId != null) || (this.moIId != null && !this.moIId.equals(other.moIId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.DopInfoMoI[ moIId=" + moIId + " ]";
    }
    
}
