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
@Table(name = "spr_name")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SprName extends Spr {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "sprNameId")
//    private Collection<SpisokLpmo> spisokLpmoCollection;

    public SprName() {
    }

    public SprName(/*Integer id,*/ String name) {
//        this.id = id;
        this.name = name;
    }
    /*public SprName(Integer id) {
        this.id = id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Collection<SpisokLpmo> getSpisokLpmoCollection() {
//        return spisokLpmoCollection;
//    }
//
//    public void setSpisokLpmoCollection(Collection<SpisokLpmo> spisokLpmoCollection) {
//        this.spisokLpmoCollection = spisokLpmoCollection;
//    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprName)) {
            return false;
        }
        SprName other = (SprName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SprName[ id=" + id + " ]";
    }*/
    
}
