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
@Table(name = "svl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Svl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_p")
    private int idP;
    @Size(max = 100)
    @Column(name = "name_p")
    private String nameP;
    @Column(name = "fio_vrach")
    private Integer fioVrach;
    @Column(name = "vid_p")
    private Character vidP;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sum_op")
    private Double sumOp;

    public Svl() {
    }

    public Svl(Integer id) {
        this.id = id;
    }

    public Svl(Integer id, int idP) {
        this.id = id;
        this.idP = idP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public Integer getFioVrach() {
        return fioVrach;
    }

    public void setFioVrach(Integer fioVrach) {
        this.fioVrach = fioVrach;
    }

    public Character getVidP() {
        return vidP;
    }

    public void setVidP(Character vidP) {
        this.vidP = vidP;
    }

    public Double getSumOp() {
        return sumOp;
    }

    public void setSumOp(Double sumOp) {
        this.sumOp = sumOp;
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
        if (!(object instanceof Svl)) {
            return false;
        }
        Svl other = (Svl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Svl[ id=" + id + " ]";
    }
    
}
