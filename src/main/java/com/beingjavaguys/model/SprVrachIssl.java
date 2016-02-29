/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_vrach_issl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprVrachIssl  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name_p")
    private String nameP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bvi")
    private boolean bvi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sum_op")
    private Double sumOp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isp_v_polikl")
    private boolean ispVPolikl;
    @Size(max = 50)
    @Column(name = "komentarii")
    private String komentarii;
    @Size(max = 10)
    @Column(name = "kab")
    private String kab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vsem")
    private boolean vsem;
    @Column(name = "vid_mo")
    private Integer vidMo;
    @Column(name = "pol")
    private Integer pol;
    @Column(name = "vozrusl")
    private Integer vozrusl;
    @Column(name = "vozr")
    private Integer vozr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stoimost")
    private boolean stoimost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_naz_vr")
    private boolean poNazVr;
    @Column(name = "parent")
    private Integer parent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sprVrachIssl")
    private IntervPriem intervPriem;

    public SprVrachIssl() {
    }

    /*public SprVrachIssl(Integer id) {
        this.id = id;
    }

    public SprVrachIssl(Integer id, String nameP, boolean bvi, boolean ispVPolikl, boolean vsem, boolean stoimost, boolean poNazVr) {
        this.id = id;
        this.nameP = nameP;
        this.bvi = bvi;
        this.ispVPolikl = ispVPolikl;
        this.vsem = vsem;
        this.stoimost = stoimost;
        this.poNazVr = poNazVr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public boolean getBvi() {
        return bvi;
    }

    public void setBvi(boolean bvi) {
        this.bvi = bvi;
    }

    public Double getSumOp() {
        return sumOp;
    }

    public void setSumOp(Double sumOp) {
        this.sumOp = sumOp;
    }

    public boolean getIspVPolikl() {
        return ispVPolikl;
    }

    public void setIspVPolikl(boolean ispVPolikl) {
        this.ispVPolikl = ispVPolikl;
    }

    public String getKomentarii() {
        return komentarii;
    }

    public void setKomentarii(String komentarii) {
        this.komentarii = komentarii;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public boolean getVsem() {
        return vsem;
    }

    public void setVsem(boolean vsem) {
        this.vsem = vsem;
    }

    public Integer getVidMo() {
        return vidMo;
    }

    public void setVidMo(Integer vidMo) {
        this.vidMo = vidMo;
    }

    public Integer getPol() {
        return pol;
    }

    public void setPol(Integer pol) {
        this.pol = pol;
    }

    public Integer getVozrusl() {
        return vozrusl;
    }

    public void setVozrusl(Integer vozrusl) {
        this.vozrusl = vozrusl;
    }

    public Integer getVozr() {
        return vozr;
    }

    public void setVozr(Integer vozr) {
        this.vozr = vozr;
    }

    public boolean getStoimost() {
        return stoimost;
    }

    public void setStoimost(boolean stoimost) {
        this.stoimost = stoimost;
    }

    public boolean getPoNazVr() {
        return poNazVr;
    }

    public void setPoNazVr(boolean poNazVr) {
        this.poNazVr = poNazVr;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public IntervPriem getIntervPriem() {
        return intervPriem;
    }

    public void setIntervPriem(IntervPriem intervPriem) {
        this.intervPriem = intervPriem;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprVrachIssl)) {
            return false;
        }
        SprVrachIssl other = (SprVrachIssl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprVrachIssl[ id=" + id + " ]";
    }*/
    
}
