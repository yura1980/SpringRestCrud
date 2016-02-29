/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "spr_fam")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprFam extends Spr {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fam")
    private String fam;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprFamId")
//    private Collection<SpisokLpmo> spisokLpmoCollection;

    public SprFam() {
    }

//    public SprFam(Integer id) {
//        this.id = id;
//    }
//
    public SprFam(String fam) {
//        this.id = id;
        this.fam = fam;
    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

//    public Collection<SpisokLpmo> getSpisokLpmoCollection() {
//        return spisokLpmoCollection;
//    }
//
//    public void setSpisokLpmoCollection(Collection<SpisokLpmo> spisokLpmoCollection) {
//        this.spisokLpmoCollection = spisokLpmoCollection;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SprFam)) {
//            return false;
//        }
//        SprFam other = (SprFam) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Spr[ id=" + id + " ]";
//    }
    
}
