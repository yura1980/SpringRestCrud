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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "zapisi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Zapisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "datas")
    @Temporal(TemporalType.DATE)
    private Date datas;
    @Column(name = "vremja")
    @Temporal(TemporalType.TIME)
    private Date vremja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "zapis")
    private String zapis;
    @Column(name = "cena")
    private Integer cena;

    public Zapisi() {
    }

    public Zapisi(Integer id) {
        this.id = id;
    }

    public Zapisi(Integer id, String zapis) {
        this.id = id;
        this.zapis = zapis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatas() {
        return datas;
    }

    public void setDatas(Date datas) {
        this.datas = datas;
    }

    public Date getVremja() {
        return vremja;
    }

    public void setVremja(Date vremja) {
        this.vremja = vremja;
    }

    public String getZapis() {
        return zapis;
    }

    public void setZapis(String zapis) {
        this.zapis = zapis;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
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
        if (!(object instanceof Zapisi)) {
            return false;
        }
        Zapisi other = (Zapisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.Zapisi[ id=" + id + " ]";
    }
    
}
