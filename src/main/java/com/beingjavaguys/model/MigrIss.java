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
@Table(name = "migr_iss")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MigrIss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sv")
    private int idSv;
    @Column(name = "iss")
    private Integer iss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obn")
    private boolean obn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr")
    private Double pr;
    @Size(max = 250)
    @Column(name = "prim")
    private String prim;

    public MigrIss() {
    }

    public MigrIss(Integer id) {
        this.id = id;
    }

    public MigrIss(Integer id, int idSv, boolean obn) {
        this.id = id;
        this.idSv = idSv;
        this.obn = obn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    public Integer getIss() {
        return iss;
    }

    public void setIss(Integer iss) {
        this.iss = iss;
    }

    public boolean getObn() {
        return obn;
    }

    public void setObn(boolean obn) {
        this.obn = obn;
    }

    public Double getPr() {
        return pr;
    }

    public void setPr(Double pr) {
        this.pr = pr;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
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
        if (!(object instanceof MigrIss)) {
            return false;
        }
        MigrIss other = (MigrIss) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MigrIss[ id=" + id + " ]";
    }
    
}
