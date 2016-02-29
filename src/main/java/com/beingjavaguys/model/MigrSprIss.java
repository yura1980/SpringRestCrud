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
@Table(name = "migr_spr_iss")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MigrSprIss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "is_cod")
    private Integer isCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "issl")
    private String issl;

    public MigrSprIss() {
    }

    public MigrSprIss(Integer isCod) {
        this.isCod = isCod;
    }

    public MigrSprIss(Integer isCod, String issl) {
        this.isCod = isCod;
        this.issl = issl;
    }

    public Integer getIsCod() {
        return isCod;
    }

    public void setIsCod(Integer isCod) {
        this.isCod = isCod;
    }

    public String getIssl() {
        return issl;
    }

    public void setIssl(String issl) {
        this.issl = issl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isCod != null ? isCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigrSprIss)) {
            return false;
        }
        MigrSprIss other = (MigrSprIss) object;
        if ((this.isCod == null && other.isCod != null) || (this.isCod != null && !this.isCod.equals(other.isCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MigrSprIss[ isCod=" + isCod + " ]";
    }
    
}
