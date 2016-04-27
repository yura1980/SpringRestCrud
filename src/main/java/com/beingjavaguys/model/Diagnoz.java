/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "diagnoz")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Diagnoz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "diagnoz", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MkbDiagnos diagnoz;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "diagnoz")
//    private int diagnoz;
    @Column(name = "vpervye")
    private Boolean vpervye;
//    @JoinColumn(name = "mo_i_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private MoI moIId;
    @Column(name = "mo_i_id")
    private long moIId;


    public Diagnoz() {
    }

//    public Diagnoz(Integer id) {
//        this.id = id;
//    }
//
//    public Diagnoz(Integer id, int diagnoz) {
//        this.id = id;
//        this.diagnoz = diagnoz;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MkbDiagnos getDiagnoz() {
        return diagnoz;
    }

    public void setDiagnoz(MkbDiagnos diagnoz) {
        this.diagnoz = diagnoz;
    }

    public Boolean getVpervye() {
        return vpervye;
    }

    public void setVpervye(Boolean vpervye) {
        this.vpervye = vpervye;
    }

    public long getMoIId() {
        return moIId;
    }

    public void setMoIId(long moIId) {
        this.moIId = moIId;
    }

    //    public MoI getMoIId() {
//        return moIId;
//    }
//
//    public void setMoIId(MoI moIId) {
//        this.moIId = moIId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnoz)) {
            return false;
        }
        Diagnoz other = (Diagnoz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Diagnoz[ id=" + id + " ]";
    }
    
}
