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
@Table(name = "mkb_subclass")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MkbSubclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private Integer code;
    @Size(max = 9)
    @Column(name = "code_t_r")
    private String codeTR;
    @Size(max = 150)
    @Column(name = "mkb")
    private String mkb;
    @Column(name = "id_class")
    private Integer idClass;
    @Column(name = "note")
    private Character note;

    public MkbSubclass() {
    }

    public MkbSubclass(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeTR() {
        return codeTR;
    }

    public void setCodeTR(String codeTR) {
        this.codeTR = codeTR;
    }

    public String getMkb() {
        return mkb;
    }

    public void setMkb(String mkb) {
        this.mkb = mkb;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
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
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbSubclass)) {
            return false;
        }
        MkbSubclass other = (MkbSubclass) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MkbSubclass[ code=" + code + " ]";
    }
    
}
