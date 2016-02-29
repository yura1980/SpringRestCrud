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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_obshhie_med_protivopokazanija")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprObshhieMedProtivopokazanija  extends Spr  {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Size(max = 50)
    @Column(name = "nomer")
    private String nomer;
    @Column(name = "protivopokazanija")
    private Boolean protivopokazanija;

    public SprObshhieMedProtivopokazanija() {
    }

    /*public SprObshhieMedProtivopokazanija(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Boolean getProtivopokazanija() {
        return protivopokazanija;
    }

    public void setProtivopokazanija(Boolean protivopokazanija) {
        this.protivopokazanija = protivopokazanija;
    }

   /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprObshhieMedProtivopokazanija)) {
            return false;
        }
        SprObshhieMedProtivopokazanija other = (SprObshhieMedProtivopokazanija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprObshhieMedProtivopokazanija[ id=" + id + " ]";
    }*/
    
}
