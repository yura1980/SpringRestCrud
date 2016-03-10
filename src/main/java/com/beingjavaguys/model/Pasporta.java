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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "pasporta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pasporta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")//"spisok_lpmo_kl")
    private long id;//spisokLpmoKl;
    @Size(max = 15)
    @Column(name = "pasport")
    private String pasport;
    @Column(name = "datas_vydachi")
    @Temporal(TemporalType.DATE)
    private Date datasVydachi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "migrant")
    private boolean migrant1;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pasporta")
//    private Migrant migrant;
//    @JoinColumn(name = "spisok_lpmo_kl", referencedColumnName = "kl", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private SpisokLpmo spisokLpmo;
    @JoinColumn(name = "spr_gragdanstvo_id", referencedColumnName = "id")
    @ManyToOne
    private SprGragdanstvo sprGragdanstvoId;
    @JoinColumn(name = "spr_pasp_kem_vydan_id", referencedColumnName = "id")
    @ManyToOne
    private SprPaspKemVydan sprPaspKemVydanId;

    public Pasporta() {
    }

//    public Pasporta(Integer spisokLpmoKl) {
//        this.id = id;
//    }
//
//    public Pasporta(Integer spisokLpmoKl, boolean migrant1) {
//        this.spisokLpmoKl = spisokLpmoKl;
//        this.migrant1 = migrant1;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Integer getSpisokLpmoKl() {
//        return spisokLpmoKl;
//    }
//
//    public void setSpisokLpmoKl(Integer spisokLpmoKl) {
//        this.spisokLpmoKl = spisokLpmoKl;
//    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public Date getDatasVydachi() {
        return datasVydachi;
    }

    public void setDatasVydachi(Date datasVydachi) {
        this.datasVydachi = datasVydachi;
    }

    public boolean getMigrant1() {
        return migrant1;
    }

    public void setMigrant1(boolean migrant1) {
        this.migrant1 = migrant1;
    }

//    public Migrant getMigrant() {
//        return migrant;
//    }
//
//    public void setMigrant(Migrant migrant) {
//        this.migrant = migrant;
//    }

//    public SpisokLpmo getSpisokLpmo() {
//        return spisokLpmo;
//    }
//
//    public void setSpisokLpmo(SpisokLpmo spisokLpmo) {
//        this.spisokLpmo = spisokLpmo;
//    }

    public SprGragdanstvo getSprGragdanstvoId() {
        return sprGragdanstvoId;
    }

    public void setSprGragdanstvoId(SprGragdanstvo sprGragdanstvoId) {
        this.sprGragdanstvoId = sprGragdanstvoId;
    }

    public SprPaspKemVydan getSprPaspKemVydanId() {
        return sprPaspKemVydanId;
    }

    public void setSprPaspKemVydanId(SprPaspKemVydan sprPaspKemVydanId) {
        this.sprPaspKemVydanId = sprPaspKemVydanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasporta)) {
            return false;
        }
        Pasporta other = (Pasporta) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pasporta[ spisokLpmoKl=" + id + " ]";
    }
    
}
