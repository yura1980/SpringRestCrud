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
@Table(name = "spr_dispanser")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprDispanser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "god")
    private Integer god;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vr_iss")
    private String vrIss;

    public SprDispanser() {
    }

    public SprDispanser(Integer god) {
        this.god = god;
    }

    public SprDispanser(Integer god, String vrIss) {
        this.god = god;
        this.vrIss = vrIss;
    }

    public Integer getGod() {
        return god;
    }

    public void setGod(Integer god) {
        this.god = god;
    }

    public String getVrIss() {
        return vrIss;
    }

    public void setVrIss(String vrIss) {
        this.vrIss = vrIss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (god != null ? god.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprDispanser)) {
            return false;
        }
        SprDispanser other = (SprDispanser) object;
        if ((this.god == null && other.god != null) || (this.god != null && !this.god.equals(other.god))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.SprDispanser[ god=" + god + " ]";
    }
    
}
