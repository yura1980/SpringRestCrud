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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "events_rez")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventsRez implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_t")
    @Temporal(TemporalType.DATE)
    private Date dateT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Size(max = 100)
    @Column(name = "tip_events")
    private String tipEvents;
    @Column(name = "kl")
    private Integer kl;
    @Column(name = "pos")
    private Integer pos;
    @Size(max = 100)
    @Column(name = "info")
    private String info;

    public EventsRez() {
    }

    public EventsRez(Integer id) {
        this.id = id;
    }

    public EventsRez(Integer id, Date dateT, int idUser) {
        this.id = id;
        this.dateT = dateT;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateT() {
        return dateT;
    }

    public void setDateT(Date dateT) {
        this.dateT = dateT;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTipEvents() {
        return tipEvents;
    }

    public void setTipEvents(String tipEvents) {
        this.tipEvents = tipEvents;
    }

    public Integer getKl() {
        return kl;
    }

    public void setKl(Integer kl) {
        this.kl = kl;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        if (!(object instanceof EventsRez)) {
            return false;
        }
        EventsRez other = (EventsRez) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentyity2.EventsRez[ id=" + id + " ]";
    }
    
}
