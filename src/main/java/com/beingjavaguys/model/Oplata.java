/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "oplata")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Oplata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oplata")
    private boolean oplata;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena")
    private Double cena;
    @Column(name = "skidka")
    private Double skidka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dispans")
    private boolean dispans;
    @Column(name = "data_dispans")
    @Temporal(TemporalType.DATE)
    private Date dataDispans;
//    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "id", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Poseshenie poseshenie;

    public Oplata() {
    }

//    public Oplata(Integer spisokLpmoKl) {
//        this.id = spisokLpmoKl;
//    }
//
//    public Oplata(Integer spisokLpmoKl, boolean oplata, boolean dispans) {
//        this.id = spisokLpmoKl;
//        this.oplata = oplata;
//        this.dispans = dispans;
//    }

//    public Integer getSpisokLpmoKl() {
//        return spisokLpmoKl;
//    }
//
//    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
//        this.spisokLpmoKl = spisokLpmoKl;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getOplata() {
        return oplata;
    }

    public void setOplata(boolean oplata) {
        this.oplata = oplata;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Double getSkidka() {
        return skidka;
    }

    public void setSkidka(Double skidka) {
        this.skidka = skidka;
    }

    public boolean getDispans() {
        return dispans;
    }

    public void setDispans(boolean dispans) {
        this.dispans = dispans;
    }

    public Date getDataDispans() {
        return dataDispans;
    }

    public void setDataDispans(Date dataDispans) {
        this.dataDispans = dataDispans;
    }

//    public Poseshenie getPoseshenie() {
//        return poseshenie;
//    }
//
//    public void setPoseshenie(Poseshenie poseshenie) {
//        this.poseshenie = poseshenie;
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
        if (!(object instanceof Oplata)) {
            return false;
        }
        Oplata other = (Oplata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oplata[ id=" + id + " ]";
    }
    
}
