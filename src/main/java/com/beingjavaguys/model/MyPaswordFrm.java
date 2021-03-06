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
@Table(name = "my_pasword_frm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MyPaswordFrm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_par")
    private int idPar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_frm")
    private int idFrm;
    @Column(name = "id_dost")
    private Integer idDost;

    public MyPaswordFrm() {
    }

    public MyPaswordFrm(Integer id) {
        this.id = id;
    }

    public MyPaswordFrm(Integer id, int idPar, int idFrm) {
        this.id = id;
        this.idPar = idPar;
        this.idFrm = idFrm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPar() {
        return idPar;
    }

    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }

    public int getIdFrm() {
        return idFrm;
    }

    public void setIdFrm(int idFrm) {
        this.idFrm = idFrm;
    }

    public Integer getIdDost() {
        return idDost;
    }

    public void setIdDost(Integer idDost) {
        this.idDost = idDost;
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
        if (!(object instanceof MyPaswordFrm)) {
            return false;
        }
        MyPaswordFrm other = (MyPaswordFrm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MyPaswordFrm[ id=" + id + " ]";
    }
    
}
