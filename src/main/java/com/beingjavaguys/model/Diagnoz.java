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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "diagnoz")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Diagnoz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagnoz")
    private int diagnoz;
    @Column(name = "vpervye")
    private Boolean vpervye;
    @JoinColumn(name = "mo_i_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MoI moIId;

    public Diagnoz() {
    }

    public Diagnoz(Integer id) {
        this.id = id;
    }

    public Diagnoz(Integer id, int diagnoz) {
        this.id = id;
        this.diagnoz = diagnoz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDiagnoz() {
        return diagnoz;
    }

    public void setDiagnoz(int diagnoz) {
        this.diagnoz = diagnoz;
    }

    public Boolean getVpervye() {
        return vpervye;
    }

    public void setVpervye(Boolean vpervye) {
        this.vpervye = vpervye;
    }

    public MoI getMoIId() {
        return moIId;
    }

    public void setMoIId(MoI moIId) {
        this.moIId = moIId;
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
        if (!(object instanceof Diagnoz)) {
            return false;
        }
        Diagnoz other = (Diagnoz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Diagnoz[ id=" + id + " ]";
    }
    
}
