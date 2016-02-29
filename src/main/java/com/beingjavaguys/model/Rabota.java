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

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "rabota")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rabota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "stazh_obshh")
    @Temporal(TemporalType.DATE)
    private Date stazhObshh;
    @Column(name = "stazh_tekushh")
    @Temporal(TemporalType.DATE)
    private Date stazhTekushh;
//    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private SpisokLpmo spisokLpmo;
    @JoinColumn(name = "spr_mesto_raboty_id", referencedColumnName = "id")
    @ManyToOne
    private SprMestoRaboty sprMestoRabotyId;
    @JoinColumn(name = "spr_org_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprOrg sprOrgId;
    @JoinColumn(name = "spr_profesija_id", referencedColumnName = "id")
    @ManyToOne
    private SprProfesija sprProfesijaId;

    public Rabota() {
    }

    public Rabota(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStazhObshh() {
        return stazhObshh;
    }

    public void setStazhObshh(Date stazhObshh) {
        this.stazhObshh = stazhObshh;
    }

    public Date getStazhTekushh() {
        return stazhTekushh;
    }

    public void setStazhTekushh(Date stazhTekushh) {
        this.stazhTekushh = stazhTekushh;
    }

//    public SpisokLpmo getSpisokLpmo() {
//        return spisokLpmo;
//    }
//
//    public void setSpisokLpmo(SpisokLpmo spisokLpmo) {
//        this.spisokLpmo = spisokLpmo;
//    }

    public SprMestoRaboty getSprMestoRabotyId() {
        return sprMestoRabotyId;
    }

    public void setSprMestoRabotyId(SprMestoRaboty sprMestoRabotyId) {
        this.sprMestoRabotyId = sprMestoRabotyId;
    }

    public SprOrg getSprOrgId() {
        return sprOrgId;
    }

    public void setSprOrgId(SprOrg sprOrgId) {
        this.sprOrgId = sprOrgId;
    }

    public SprProfesija getSprProfesijaId() {
        return sprProfesijaId;
    }

    public void setSprProfesijaId(SprProfesija sprProfesijaId) {
        this.sprProfesijaId = sprProfesijaId;
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
        if (!(object instanceof Rabota)) {
            return false;
        }
        Rabota other = (Rabota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rabota[ spisokLpmoKl=" + id + " ]";
    }
    
}
