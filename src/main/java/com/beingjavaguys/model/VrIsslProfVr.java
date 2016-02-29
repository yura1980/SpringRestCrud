/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "vr_issl_prof_vr")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VrIsslProfVr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idprofvr")
    private Integer idprofvr;
    @Column(name = "nomer")
    private Integer nomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vrach")
    private boolean vrach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ppokaz")
    private boolean ppokaz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dop")
    private boolean dop;
    @Column(name = "koddop")
    private Integer koddop;
    @Column(name = "vidmo")
    private Integer vidmo;

    public VrIsslProfVr() {
    }

    public VrIsslProfVr(Integer id) {
        this.id = id;
    }

    public VrIsslProfVr(Integer id, boolean vrach, boolean ppokaz, boolean dop) {
        this.id = id;
        this.vrach = vrach;
        this.ppokaz = ppokaz;
        this.dop = dop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdprofvr() {
        return idprofvr;
    }

    public void setIdprofvr(Integer idprofvr) {
        this.idprofvr = idprofvr;
    }

    public Integer getNomer() {
        return nomer;
    }

    public void setNomer(Integer nomer) {
        this.nomer = nomer;
    }

    public boolean getVrach() {
        return vrach;
    }

    public void setVrach(boolean vrach) {
        this.vrach = vrach;
    }

    public boolean getPpokaz() {
        return ppokaz;
    }

    public void setPpokaz(boolean ppokaz) {
        this.ppokaz = ppokaz;
    }

    public boolean getDop() {
        return dop;
    }

    public void setDop(boolean dop) {
        this.dop = dop;
    }

    public Integer getKoddop() {
        return koddop;
    }

    public void setKoddop(Integer koddop) {
        this.koddop = koddop;
    }

    public Integer getVidmo() {
        return vidmo;
    }

    public void setVidmo(Integer vidmo) {
        this.vidmo = vidmo;
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
        if (!(object instanceof VrIsslProfVr)) {
            return false;
        }
        VrIsslProfVr other = (VrIsslProfVr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.VrIsslProfVr[ id=" + id + " ]";
    }
    
}
