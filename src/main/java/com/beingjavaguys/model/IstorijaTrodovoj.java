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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "istorija_trodovoj")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IstorijaTrodovoj implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IstorijaTrodovojPK istorijaTrodovojPK;
    @Column(name = "v_prof_s")
    @Temporal(TemporalType.DATE)
    private Date vProfS;
    @Column(name = "v_prof_po")
    @Temporal(TemporalType.DATE)
    private Date vProfPo;
    @Column(name = "id_prof")
    private Integer idProf;
    @Column(name = "id_rab")
    private Integer idRab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_org")
    private int idOrg;
    @JoinColumn(name = "poseshenie_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Poseshenie poseshenie;

    public IstorijaTrodovoj() {
    }

    public IstorijaTrodovoj(IstorijaTrodovojPK istorijaTrodovojPK) {
        this.istorijaTrodovojPK = istorijaTrodovojPK;
    }

    public IstorijaTrodovoj(IstorijaTrodovojPK istorijaTrodovojPK, int idOrg) {
        this.istorijaTrodovojPK = istorijaTrodovojPK;
        this.idOrg = idOrg;
    }

    public IstorijaTrodovoj(int poseshenieId, int kl) {
        this.istorijaTrodovojPK = new IstorijaTrodovojPK(poseshenieId, kl);
    }

    public IstorijaTrodovojPK getIstorijaTrodovojPK() {
        return istorijaTrodovojPK;
    }

    public void setIstorijaTrodovojPK(IstorijaTrodovojPK istorijaTrodovojPK) {
        this.istorijaTrodovojPK = istorijaTrodovojPK;
    }

    public Date getVProfS() {
        return vProfS;
    }

    public void setVProfS(Date vProfS) {
        this.vProfS = vProfS;
    }

    public Date getVProfPo() {
        return vProfPo;
    }

    public void setVProfPo(Date vProfPo) {
        this.vProfPo = vProfPo;
    }

    public Integer getIdProf() {
        return idProf;
    }

    public void setIdProf(Integer idProf) {
        this.idProf = idProf;
    }

    public Integer getIdRab() {
        return idRab;
    }

    public void setIdRab(Integer idRab) {
        this.idRab = idRab;
    }

    public int getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    public Poseshenie getPoseshenie() {
        return poseshenie;
    }

    public void setPoseshenie(Poseshenie poseshenie) {
        this.poseshenie = poseshenie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (istorijaTrodovojPK != null ? istorijaTrodovojPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IstorijaTrodovoj)) {
            return false;
        }
        IstorijaTrodovoj other = (IstorijaTrodovoj) object;
        if ((this.istorijaTrodovojPK == null && other.istorijaTrodovojPK != null) || (this.istorijaTrodovojPK != null && !this.istorijaTrodovojPK.equals(other.istorijaTrodovojPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.IstorijaTrodovoj[ istorijaTrodovojPK=" + istorijaTrodovojPK + " ]";
    }
    
}
