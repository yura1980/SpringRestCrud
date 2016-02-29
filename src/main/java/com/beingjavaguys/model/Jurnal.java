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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author yuri
 */
@Entity
@Table(name = "jurnal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Jurnal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rn")
    private Integer rn;
    @Column(name = "datas_reg")
    @Temporal(TemporalType.DATE)
    private Date datasReg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obrabotka_dok")
    private boolean obrabotkaDok;
    @Column(name = "zakl_akt")
    @Temporal(TemporalType.DATE)
    private Date zaklAkt;
    @Column(name = "id_vid_pmo")
    private Integer idVidPmo;
    @JoinColumn(name = "spr_org_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprOrg sprOrgId;
    @JoinColumn(name = "spr_polikliniki_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprPolikliniki sprPoliklinikiId;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jurnalRn")
//    private Collection<Poseshenie> poseshenieCollection;

    public Jurnal() {
    }

    public Jurnal(Integer rn) {
        this.rn = rn;
    }

    public Jurnal(Integer rn, boolean obrabotkaDok) {
        this.rn = rn;
        this.obrabotkaDok = obrabotkaDok;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Date getDatasReg() {
        return datasReg;
    }

    public void setDatasReg(Date datasReg) {
        this.datasReg = datasReg;
    }

    public boolean getObrabotkaDok() {
        return obrabotkaDok;
    }

    public void setObrabotkaDok(boolean obrabotkaDok) {
        this.obrabotkaDok = obrabotkaDok;
    }

    public Date getZaklAkt() {
        return zaklAkt;
    }

    public void setZaklAkt(Date zaklAkt) {
        this.zaklAkt = zaklAkt;
    }

    public Integer getIdVidPmo() {
        return idVidPmo;
    }

    public void setIdVidPmo(Integer idVidPmo) {
        this.idVidPmo = idVidPmo;
    }

    public SprOrg getSprOrgId() {
        return sprOrgId;
    }

    public void setSprOrgId(SprOrg sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public SprPolikliniki getSprPoliklinikiId() {
        return sprPoliklinikiId;
    }

    public void setSprPoliklinikiId(SprPolikliniki sprPoliklinikiId) {
        this.sprPoliklinikiId = sprPoliklinikiId;
    }

//    public Collection<Poseshenie> getPoseshenieCollection() {
//        return poseshenieCollection;
//    }
//
//    public void setPoseshenieCollection(Collection<Poseshenie> poseshenieCollection) {
//        this.poseshenieCollection = poseshenieCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rn != null ? rn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jurnal)) {
            return false;
        }
        Jurnal other = (Jurnal) object;
        if ((this.rn == null && other.rn != null) || (this.rn != null && !this.rn.equals(other.rn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Jurnal[ rn=" + rn + " ]";
    }

}
