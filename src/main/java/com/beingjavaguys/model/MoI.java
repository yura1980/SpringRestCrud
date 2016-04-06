/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beingjavaguys.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yuri
 */
@Entity
@Table(name = "mo_i")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MoI implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "vrachissl", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprVrachIssl vrachissl;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "vrachissl")
//    private int vrachissl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vrissl")
    private boolean vrissl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ppokaz")
    private boolean ppokaz;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provedeno")
    private boolean provedeno;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moIId",fetch = FetchType.EAGER)
//    private Collection<Diagnoz> diagnozCollection;
//    @JoinColumn(name = "poseshenie_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
    @NotNull
    @Column(name = "poseshenie_id")
    private long poseshenieId;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "moI")
//    private DopInfoMoI dopInfoMoI;

    @JoinColumn(name = "dopinfoid", referencedColumnName = "mo_i_id")
    @OneToOne
    private DopInfoMoI dopinfoid;

    public MoI() {
    }

    public MoI(Integer id) {
        this.id = id;
    }

//    public MoI(Integer id, int vrachissl, boolean vrissl, boolean ppokaz, boolean provedeno) {
//        this.id = id;
//        this.vrachissl = vrachissl;
//        this.vrissl = vrissl;
//        this.ppokaz = ppokaz;
//        this.provedeno = provedeno;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public int getVrachissl() {
//        return vrachissl;
//    }
//
//    public void setVrachissl(int vrachissl) {
//        this.vrachissl = vrachissl;
//    }


    public SprVrachIssl getVrachissl() {
        return vrachissl;
    }

    public void setVrachissl(SprVrachIssl vrachissl) {
        this.vrachissl = vrachissl;
    }

    public boolean getVrissl() {
        return vrissl;
    }

    public void setVrissl(boolean vrissl) {
        this.vrissl = vrissl;
    }

    public boolean getPpokaz() {
        return ppokaz;
    }

    public void setPpokaz(boolean ppokaz) {
        this.ppokaz = ppokaz;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getProvedeno() {
        return provedeno;
    }

    public void setProvedeno(boolean provedeno) {
        this.provedeno = provedeno;
    }

//    public Collection<Diagnoz> getDiagnozCollection() {
//        return diagnozCollection;
//    }
//
//    public void setDiagnozCollection(Collection<Diagnoz> diagnozCollection) {
//        this.diagnozCollection = diagnozCollection;
//    }

    public long getPoseshenieId() {
        return poseshenieId;
    }

    public void setPoseshenieId(long poseshenieId) {
        this.poseshenieId = poseshenieId;
    }

//    public DopInfoMoI getDopInfoMoI() {
//        return dopInfoMoI;
//    }
//
//    public void setDopInfoMoI(DopInfoMoI dopInfoMoI) {
//        this.dopInfoMoI = dopInfoMoI;
//    }


    public DopInfoMoI getDopinfoid() {
        return dopinfoid;
    }

    public void setDopinfoid(DopInfoMoI dopinfoid) {
        this.dopinfoid = dopinfoid;
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
        if (!(object instanceof MoI)) {
            return false;
        }
        MoI other = (MoI) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MoI[ id=" + id + " ]";
    }
    
}
