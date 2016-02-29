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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "kont_vesh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KontVesh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "kont_vesh")
    private String kontVesh;
    @JoinColumn(name = "poseshenie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Poseshenie poseshenieId;

    public KontVesh() {
    }

    public KontVesh(Integer id) {
        this.id = id;
    }

    public KontVesh(Integer id, String kontVesh) {
        this.id = id;
        this.kontVesh = kontVesh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKontVesh() {
        return kontVesh;
    }

    public void setKontVesh(String kontVesh) {
        this.kontVesh = kontVesh;
    }

    public Poseshenie getPoseshenieId() {
        return poseshenieId;
    }

    public void setPoseshenieId(Poseshenie poseshenieId) {
        this.poseshenieId = poseshenieId;
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
        if (!(object instanceof KontVesh)) {
            return false;
        }
        KontVesh other = (KontVesh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.KontVesh[ id=" + id + " ]";
    }
    
}
