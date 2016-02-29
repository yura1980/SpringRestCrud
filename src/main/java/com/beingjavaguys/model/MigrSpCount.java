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
@Table(name = "migr_sp_count")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MigrSpCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "country")
    private String country;
    @Size(max = 2)
    @Column(name = "alfa2")
    private String alfa2;
    @Size(max = 3)
    @Column(name = "alfa3")
    private String alfa3;

    public MigrSpCount() {
    }

    public MigrSpCount(Integer code) {
        this.code = code;
    }

    public MigrSpCount(Integer code, String country) {
        this.code = code;
        this.country = country;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlfa2() {
        return alfa2;
    }

    public void setAlfa2(String alfa2) {
        this.alfa2 = alfa2;
    }

    public String getAlfa3() {
        return alfa3;
    }

    public void setAlfa3(String alfa3) {
        this.alfa3 = alfa3;
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
        if (!(object instanceof MigrSpCount)) {
            return false;
        }
        MigrSpCount other = (MigrSpCount) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.MigrSpCount[ code=" + code + " ]";
    }
    
}
