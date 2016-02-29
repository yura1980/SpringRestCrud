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
@Table(name = "mkb_klassy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MkbKlassy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_class")
    private Integer idClass;
    @Size(max = 5)
    @Column(name = "n_class")
    private String nClass;
    @Size(max = 150)
    @Column(name = "class")
    private String class1;
    @Column(name = "note")
    private Character note;

    public MkbKlassy() {
    }

    public MkbKlassy(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getNClass() {
        return nClass;
    }

    public void setNClass(String nClass) {
        this.nClass = nClass;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public Character getNote() {
        return note;
    }

    public void setNote(Character note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClass != null ? idClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbKlassy)) {
            return false;
        }
        MkbKlassy other = (MkbKlassy) object;
        if ((this.idClass == null && other.idClass != null) || (this.idClass != null && !this.idClass.equals(other.idClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MkbKlassy[ idClass=" + idClass + " ]";
    }
    
}
