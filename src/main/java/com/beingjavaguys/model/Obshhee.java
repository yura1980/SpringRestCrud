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
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "obshhee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Obshhee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long id;
    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 24)
    @Column(name = "nomer_poljusa")
    private String nomerPoljusa;
    @Size(max = 20)
    @Column(name = "telefon2")
    private String telefon2;
    @Size(max = 11)
    @Column(name = "snils")
    private String snils;
//    @Column(name = "med_org")
//    private Integer medOrg;
    @JoinColumn(name = "med_org", referencedColumnName = "id")
    @ManyToOne
    private SprOrg medOrg;
//    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private SpisokLpmo spisokLpmo;

    public Obshhee() {
    }

//    public Obshhee(Integer spisokLpmoKl) {
//        this.spisokLpmoKl = spisokLpmoKl;
//    }
//
//    public Integer getSpisokLpmoKl() {
//        return spisokLpmoKl;
//    }
//
//    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
//        this.spisokLpmoKl = spisokLpmoKl;
//    }


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNomerPoljusa() {
        return nomerPoljusa;
    }

    public void setNomerPoljusa(String nomerPoljusa) {
        this.nomerPoljusa = nomerPoljusa;
    }

    public String getTelefon2() {
        return telefon2;
    }

    public void setTelefon2(String telefon2) {
        this.telefon2 = telefon2;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public SprOrg getMedOrg() {
        return medOrg;
    }

    public void setMedOrg(SprOrg medOrg) {
        this.medOrg = medOrg;
    }

//    public SpisokLpmo getSpisokLpmo() {
//        return spisokLpmo;
//    }
//
//    public void setSpisokLpmo(SpisokLpmo spisokLpmo) {
//        this.spisokLpmo = spisokLpmo;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obshhee)) {
            return false;
        }
        Obshhee other = (Obshhee) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Obshhee[ spisokLpmoKl=" + id + " ]";
    }
    
}
