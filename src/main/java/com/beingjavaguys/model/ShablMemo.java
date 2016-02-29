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
@Table(name = "shabl_memo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShablMemo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vriss")
    private int vriss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "txt_shab")
    private String txtShab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto")
    private boolean auto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto_opl")
    private boolean autoOpl;

    public ShablMemo() {
    }

    public ShablMemo(Integer id) {
        this.id = id;
    }

    public ShablMemo(Integer id, int vriss, String txtShab, boolean auto, boolean autoOpl) {
        this.id = id;
        this.vriss = vriss;
        this.txtShab = txtShab;
        this.auto = auto;
        this.autoOpl = autoOpl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVriss() {
        return vriss;
    }

    public void setVriss(int vriss) {
        this.vriss = vriss;
    }

    public String getTxtShab() {
        return txtShab;
    }

    public void setTxtShab(String txtShab) {
        this.txtShab = txtShab;
    }

    public boolean getAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public boolean getAutoOpl() {
        return autoOpl;
    }

    public void setAutoOpl(boolean autoOpl) {
        this.autoOpl = autoOpl;
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
        if (!(object instanceof ShablMemo)) {
            return false;
        }
        ShablMemo other = (ShablMemo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.ShablMemo[ id=" + id + " ]";
    }
    
}
