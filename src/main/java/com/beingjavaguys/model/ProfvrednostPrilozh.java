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
@Table(name = "profvrednost_prilozh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProfvrednostPrilozh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nomer")
    private String nomer;
    @Size(max = 900)
    @Column(name = "naimenovanie_faktorov")
    private String naimenovanieFaktorov;
    @Column(name = "periodichnost")
    private Integer periodichnost;
    @Size(max = 1200)
    @Column(name = "uchastie_vrachej")
    private String uchastieVrachej;
    @Size(max = 1200)
    @Column(name = "issl")
    private String issl;
    @Size(max = 1200)
    @Column(name = "protivopokazanija")
    private String protivopokazanija;
    @Size(max = 150)
    @Column(name = "rez")
    private String rez;
    @Size(max = 150)
    @Column(name = "rez_pr")
    private String rezPr;
    @Size(max = 45)
    @Column(name = "dop")
    private String dop;
    @Column(name = "tipproizfaktora")
    private Integer tipproizfaktora;
    @Column(name = "pril")
    private Integer pril;

    public ProfvrednostPrilozh() {
    }

    public ProfvrednostPrilozh(Integer id) {
        this.id = id;
    }

    public ProfvrednostPrilozh(Integer id, String nomer) {
        this.id = id;
        this.nomer = nomer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getNaimenovanieFaktorov() {
        return naimenovanieFaktorov;
    }

    public void setNaimenovanieFaktorov(String naimenovanieFaktorov) {
        this.naimenovanieFaktorov = naimenovanieFaktorov;
    }

    public Integer getPeriodichnost() {
        return periodichnost;
    }

    public void setPeriodichnost(Integer periodichnost) {
        this.periodichnost = periodichnost;
    }

    public String getUchastieVrachej() {
        return uchastieVrachej;
    }

    public void setUchastieVrachej(String uchastieVrachej) {
        this.uchastieVrachej = uchastieVrachej;
    }

    public String getIssl() {
        return issl;
    }

    public void setIssl(String issl) {
        this.issl = issl;
    }

    public String getProtivopokazanija() {
        return protivopokazanija;
    }

    public void setProtivopokazanija(String protivopokazanija) {
        this.protivopokazanija = protivopokazanija;
    }

    public String getRez() {
        return rez;
    }

    public void setRez(String rez) {
        this.rez = rez;
    }

    public String getRezPr() {
        return rezPr;
    }

    public void setRezPr(String rezPr) {
        this.rezPr = rezPr;
    }

    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    public Integer getTipproizfaktora() {
        return tipproizfaktora;
    }

    public void setTipproizfaktora(Integer tipproizfaktora) {
        this.tipproizfaktora = tipproizfaktora;
    }

    public Integer getPril() {
        return pril;
    }

    public void setPril(Integer pril) {
        this.pril = pril;
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
        if (!(object instanceof ProfvrednostPrilozh)) {
            return false;
        }
        ProfvrednostPrilozh other = (ProfvrednostPrilozh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.ProfvrednostPrilozh[ id=" + id + " ]";
    }
    
}
