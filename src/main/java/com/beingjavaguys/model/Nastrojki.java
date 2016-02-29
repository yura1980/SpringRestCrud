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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "nastrojki")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nastrojki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_pol")
    private Integer idPol;
    @Size(max = 254)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 254)
    @Column(name = "adres")
    private String adres;
    @Size(max = 50)
    @Column(name = "gl_vrach")
    private String glVrach;
    @Size(max = 50)
    @Column(name = "pr_adm")
    private String prAdm;
    @Size(max = 100)
    @Column(name = "sokr_name")
    private String sokrName;
    @Column(name = "pr_kom")
    private Integer prKom;
    @Column(name = "chlen_kom1")
    private Integer chlenKom1;
    @Column(name = "chlen_kom2")
    private Integer chlenKom2;
    @Column(name = "chlen_kom3")
    private Integer chlenKom3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zgf")
    private boolean zgf;
    @Size(max = 100)
    @Column(name = "obaz")
    private String obaz;
    @Size(max = 26)
    @Column(name = "ogrn")
    private String ogrn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cenadog")
    private Double cenadog;
    @Column(name = "tekushhnomdog")
    private Integer tekushhnomdog;
    @Size(max = 100)
    @Column(name = "licenzija")
    private String licenzija;
    @Size(max = 550)
    @Column(name = "rekvizity")
    private String rekvizity;
    @Size(max = 70)
    @Column(name = "gorod")
    private String gorod;
    @Size(max = 254)
    @Column(name = "shapkadog")
    private String shapkadog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomspr")
    private boolean nomspr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akrf")
    private boolean akrf;

    public Nastrojki() {
    }

    public Nastrojki(Integer id) {
        this.id = id;
    }

    public Nastrojki(Integer id, boolean zgf, boolean nomspr, boolean akrf) {
        this.id = id;
        this.zgf = zgf;
        this.nomspr = nomspr;
        this.akrf = akrf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPol() {
        return idPol;
    }

    public void setIdPol(Integer idPol) {
        this.idPol = idPol;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getGlVrach() {
        return glVrach;
    }

    public void setGlVrach(String glVrach) {
        this.glVrach = glVrach;
    }

    public String getPrAdm() {
        return prAdm;
    }

    public void setPrAdm(String prAdm) {
        this.prAdm = prAdm;
    }

    public String getSokrName() {
        return sokrName;
    }

    public void setSokrName(String sokrName) {
        this.sokrName = sokrName;
    }

    public Integer getPrKom() {
        return prKom;
    }

    public void setPrKom(Integer prKom) {
        this.prKom = prKom;
    }

    public Integer getChlenKom1() {
        return chlenKom1;
    }

    public void setChlenKom1(Integer chlenKom1) {
        this.chlenKom1 = chlenKom1;
    }

    public Integer getChlenKom2() {
        return chlenKom2;
    }

    public void setChlenKom2(Integer chlenKom2) {
        this.chlenKom2 = chlenKom2;
    }

    public Integer getChlenKom3() {
        return chlenKom3;
    }

    public void setChlenKom3(Integer chlenKom3) {
        this.chlenKom3 = chlenKom3;
    }

    public boolean getZgf() {
        return zgf;
    }

    public void setZgf(boolean zgf) {
        this.zgf = zgf;
    }

    public String getObaz() {
        return obaz;
    }

    public void setObaz(String obaz) {
        this.obaz = obaz;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public Double getCenadog() {
        return cenadog;
    }

    public void setCenadog(Double cenadog) {
        this.cenadog = cenadog;
    }

    public Integer getTekushhnomdog() {
        return tekushhnomdog;
    }

    public void setTekushhnomdog(Integer tekushhnomdog) {
        this.tekushhnomdog = tekushhnomdog;
    }

    public String getLicenzija() {
        return licenzija;
    }

    public void setLicenzija(String licenzija) {
        this.licenzija = licenzija;
    }

    public String getRekvizity() {
        return rekvizity;
    }

    public void setRekvizity(String rekvizity) {
        this.rekvizity = rekvizity;
    }

    public String getGorod() {
        return gorod;
    }

    public void setGorod(String gorod) {
        this.gorod = gorod;
    }

    public String getShapkadog() {
        return shapkadog;
    }

    public void setShapkadog(String shapkadog) {
        this.shapkadog = shapkadog;
    }

    public boolean getNomspr() {
        return nomspr;
    }

    public void setNomspr(boolean nomspr) {
        this.nomspr = nomspr;
    }

    public boolean getAkrf() {
        return akrf;
    }

    public void setAkrf(boolean akrf) {
        this.akrf = akrf;
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
        if (!(object instanceof Nastrojki)) {
            return false;
        }
        Nastrojki other = (Nastrojki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Nastrojki[ id=" + id + " ]";
    }
    
}
